package com.cinemind.catalog.service;

import com.cinemind.catalog.dto.ContentResponseDTO;
import com.cinemind.catalog.entity.Content;
import com.cinemind.catalog.entity.ContentType;
import com.cinemind.catalog.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final ContentRepository contentRepository;

    @Transactional(readOnly = true)
    public ContentResponseDTO getById(Long id) {
        Content content = contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Content not found with id: " + id));
        return mapToDTO(content);
    }

    @Transactional(readOnly = true)
    public List<ContentResponseDTO> getByType(ContentType type) {
        return contentRepository.findByContentType(String.valueOf(type))
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Placeholder for Trie-based search
    public List<ContentResponseDTO> searchByTitle(String query) {
        // Logic:
        // 1. Get IDs from TrieService
        // 2. Fetch full objects from ContentRepository
        return List.of();
    }

    // Helper method to convert Entity -> DTO
    private ContentResponseDTO mapToDTO(Content content) {
        return ContentResponseDTO.builder()
                .id(content.getId())
                .title(content.getTitle())
                .contentType(content.getContentType())
                .description(content.getDescription())
                .genres(content.getGenres().stream().map(g -> g.getName()).collect(Collectors.toSet()))
                .cast(content.getCast().stream().map(a -> a.getName()).collect(Collectors.toSet()))
                .build();
    }
}