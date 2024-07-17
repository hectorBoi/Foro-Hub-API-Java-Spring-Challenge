package com.hector.foro_hub.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicModifyData(@NotNull Long topicId, @NotBlank String message) {

        public TopicModifyData(Long topicId, String message) {
                this.topicId = topicId;
                this.message = message;
        }
}
