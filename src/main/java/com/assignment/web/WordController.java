package com.assignment.web;

import com.assignment.domain.apiintegrator.github.GithubApiPopularityImpl;
import com.assignment.domain.model.WordResponseDTO;
import com.assignment.domain.service.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/words")
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
        this.wordService.setApiPopularity(new GithubApiPopularityImpl());
    }

    @GetMapping
    public ResponseEntity<WordResponseDTO> getResponseById(@RequestParam String word) {
        return ResponseEntity.ok(wordService.getWordScore(word));
    }
}
