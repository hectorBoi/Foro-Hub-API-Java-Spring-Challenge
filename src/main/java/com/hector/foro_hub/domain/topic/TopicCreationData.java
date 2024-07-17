package com.hector.foro_hub.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicCreationData(
        @NotBlank
        String title,

        @NotBlank
        String message,
        @NotNull
        LocalDateTime creationDate,

        @NotNull
        Long author) {
}
