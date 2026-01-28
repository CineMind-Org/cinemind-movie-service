package com.cinemind.catalog.repository;

import com.cinemind.catalog.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Genre findByNameIgnoreCase(String name);
}
