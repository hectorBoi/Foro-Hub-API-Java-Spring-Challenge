package com.hector.foro_hub.domain.topic;

import com.hector.foro_hub.domain.user.User;

import java.time.LocalDateTime;

public record TopicAnswerData(Long id, String title, String message, LocalDateTime creationDate, String username) {

    public TopicAnswerData(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate(), topic.getAuthor().getUsername());
    }
}
