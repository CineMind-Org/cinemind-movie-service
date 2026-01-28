package com.cinemind.catalog.repository;

import com.cinemind.catalog.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {
    // Custom query to fetch titles and IDs for Trie initialization
    // Using a projection or a specific query is faster than 'findAll()'
    @Query("SELECT c.id, c.title FROM Content c")
    List<Object[]> findAllTitlesAndIds();

    // Filter by type (MOVIE, TV_SHOW, WEB_SERIES)
    List<Content> findByContentType(String contentType);
}
