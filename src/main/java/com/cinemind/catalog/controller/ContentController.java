package com.cinemind.catalog.controller;

import com.cinemind.catalog.dto.ContentResponseDTO;
import com.cinemind.catalog.entity.ContentType;
import com.cinemind.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
@RequiredArgsConstructor // Automatically injects final fields
public class ContentController {

    private final CatalogService catalogService;

    // 1. Get Details by ID
    @GetMapping("/content/{id}")
    public ResponseEntity<ContentResponseDTO> getContentById(@PathVariable Long id) {
        return ResponseEntity.ok(catalogService.getById(id));
    }

    // 2. Trie-powered Search (Endpoint ready for next step)
    @GetMapping("/search")
    public ResponseEntity<List<ContentResponseDTO>> search(@RequestParam String q) {
        return ResponseEntity.ok(catalogService.searchByTitle(q));
    }

    // 3. Filter by Type (MOVIE, TV_SHOW)
    @GetMapping("/type/{type}")
    public ResponseEntity<List<ContentResponseDTO>> getByType(@PathVariable ContentType type) {
        return ResponseEntity.ok(catalogService.getByType(type));
    }
}