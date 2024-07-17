package com.hector.foro_hub.domain.topic;

import com.hector.foro_hub.domain.answer.Answer;
import com.hector.foro_hub.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String message;

    @Column(nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<Answer> answers;

    public Topic(String title, String message, LocalDateTime creationDate, User user) {
        this.title = title;
        this.message = message;
        this.creationDate = creationDate;
        this.author = user;
    }




    // Getters and Setters
}

