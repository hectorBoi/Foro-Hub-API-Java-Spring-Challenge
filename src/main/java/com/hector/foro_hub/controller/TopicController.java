package com.hector.foro_hub.controller;

import com.hector.foro_hub.domain.topic.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private PostTopicService service;


    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicAnswerData> postTopic (@RequestBody @Valid TopicCreationData topicCreationData, UriComponentsBuilder uriComponentsBuilder) {

        var response = service.createTopic(topicCreationData);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<TopicAnswerData>> listTopics (@PageableDefault(size=20) Pageable pages) {
        return ResponseEntity.ok(topicRepository.findAll(pages).map(TopicAnswerData::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicAnswerData> topicDetails (@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);

        return ResponseEntity.ok(new TopicAnswerData(topic));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<TopicAnswerData> modifyTopicMessage (@RequestBody @Valid TopicModifyData topicModifyData) {
        var response = service.modifyTopicMessage(topicModifyData);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic (@PathVariable Long id) {

        service.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }


}
