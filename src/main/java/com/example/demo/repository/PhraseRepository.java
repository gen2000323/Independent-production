package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Phrase;

public interface PhraseRepository extends JpaRepository<Phrase, Integer> {

    @Query(value = "SELECT * FROM phrases ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Phrase> findRandomPhrase();
}