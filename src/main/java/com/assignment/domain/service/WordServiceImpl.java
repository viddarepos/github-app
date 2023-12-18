package com.assignment.domain.service;

import com.assignment.domain.apiintegrator.ApiPopularity;
import com.assignment.domain.apiintegrator.model.Score;
import com.assignment.domain.entity.Word;
import com.assignment.domain.model.WordResponseDTO;
import com.assignment.domain.repository.SourceRepository;
import com.assignment.domain.repository.WordRepository;
import com.assignment.infrastructure.mapper.WordMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;
    private final SourceRepository sourceRepository;
    private ApiPopularity apiPopularity;
    private final WordMapper wordMapper;

    public WordServiceImpl(WordRepository wordRepository, SourceRepository sourceRepository, WordMapper wordMapper) {
        this.wordRepository = wordRepository;
        this.sourceRepository = sourceRepository;
        this.wordMapper = wordMapper;
    }

    public void setApiPopularity(ApiPopularity apiPopularity) {
        this.apiPopularity = apiPopularity;
    }

    @Override
    public WordResponseDTO getWordScore(String name) {
        Optional<Word> word = this.wordRepository.findByTerm(name);

        if (word.isPresent()) {
            return this.wordMapper.toWordResponseDTO(word.get());
        }
        try {
            Score score = apiPopularity.getPopularityScore(name);
            Word newWord = new Word();
            newWord.setNegativeCount(score.negativeCount());
            newWord.setPositiveCount(score.positiveCount());
            newWord.setTerm(name);
            newWord.setScore(score.score());
            newWord.setSource(this.sourceRepository.findByName("Github").get());
            this.wordRepository.save(newWord);
            return this.wordMapper.toWordResponseDTO(newWord);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
