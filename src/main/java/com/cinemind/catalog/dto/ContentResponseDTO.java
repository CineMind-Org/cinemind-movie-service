package com.cinemind.catalog.dto;

import com.cinemind.catalog.entity.ContentType;
import lombok.Builder;
import lombok.Data;
import java.util.Set;

@Data
@Builder
public class ContentResponseDTO {
    private Long id;
    private String title;
    private ContentType contentType;
    private String description;
    private Set<String> genres; // Just names, not the whole object
    private Set<String> cast;   // Just names
}