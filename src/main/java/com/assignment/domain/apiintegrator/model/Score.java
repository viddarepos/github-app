package com.assignment.domain.apiintegrator.model;

public record Score(
    String word,
    Double score,
    Long negativeCount,
    Long positiveCount
) {
}
