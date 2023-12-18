package com.assignment.domain.service;

import com.assignment.domain.apiintegrator.ApiPopularity;
import com.assignment.domain.model.WordResponseDTO;

public interface WordService {
    WordResponseDTO getWordScore(String name);
    void setApiPopularity(ApiPopularity apiPopularity);
}
