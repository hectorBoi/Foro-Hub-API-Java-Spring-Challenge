package com.hector.foro_hub.domain.topic;

import com.hector.foro_hub.domain.user.UserRepository;
import com.hector.foro_hub.infra.errores.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostTopicService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;
    public TopicAnswerData createTopic (TopicCreationData data) {

        if(!userRepository.findById(data.author()).isPresent()){
            throw new IntegrityValidation("Este id no fue encontrado");
        }

        var user = userRepository.findById(data.author()).get();

        var topic = new Topic(data.title(), data.message(), data.creationDate(), user);
        topicRepository.save(topic);

        return new TopicAnswerData(topic);

    }

    public TopicAnswerData modifyTopicMessage(TopicModifyData topicModifyData) {
        if(!topicRepository.findById(topicModifyData.topicId()).isPresent()) {
            throw new IntegrityValidation("Este id para post no fue encontrado");
        }
        var topic = topicRepository.findById(topicModifyData.topicId()).get();
        topic.setMessage(topicModifyData.message());

        return new TopicAnswerData(topic);
    }

    public void deleteTopic(Long id) {
        if(!topicRepository.findById(id).isPresent()) {
            throw new IntegrityValidation("Este id para post no fue encontrado");
        }
        var topic = topicRepository.findById(id).get();
        topicRepository.delete(topic);
    }
}
