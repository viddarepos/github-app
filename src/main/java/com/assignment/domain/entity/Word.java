package com.assignment.domain.entity;

import jakarta.persistence.*;

@Entity
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String term;
    private Double score;
    private Long positiveCount;
    private Long negativeCount;
    @ManyToOne()
    private Source source;

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Long getPositiveCount() {
        return positiveCount;
    }

    public void setPositiveCount(Long positiveCount) {
        this.positiveCount = positiveCount;
    }

    public Long getNegativeCount() {
        return negativeCount;
    }

    public void setNegativeCount(Long negativeCount) {
        this.negativeCount = negativeCount;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
