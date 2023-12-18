package com.assignment.domain.model;

public record WordResponseDTO(

        Long id,
        String term,
        Double score,
        Long positiveCount,
        Long negativeCount,
        String sourceName

) {
}
