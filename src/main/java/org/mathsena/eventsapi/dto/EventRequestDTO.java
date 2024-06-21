package org.mathsena.eventsapi.dto;

import org.springframework.web.multipart.MultipartFile;

public record EventRequestDTO(
    String title,
    String description,
    MultipartFile imgUrl,
    Boolean isRemote,
    String location,
    String date) {}
