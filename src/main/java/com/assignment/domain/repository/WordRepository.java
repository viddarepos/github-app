package com.assignment.domain.repository;

import com.assignment.domain.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WordRepository extends JpaRepository<Word, Long> {
    Optional<Word> findByTerm(String term);
}
