package com.assignment.infrastructure.mapper;

import com.assignment.domain.entity.Word;
import com.assignment.domain.model.WordResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WordMapper {

    WordResponseDTO toWordResponseDTO(Word word);

    Word toWord(WordResponseDTO wordResponseDTO);

}
