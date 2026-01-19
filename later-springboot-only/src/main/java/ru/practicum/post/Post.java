package ru.practicum.post;

import jakarta.persistence.*;
import lombok.Data;
import ru.practicum.user.User;

@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String text;

    // меняем тип выборки с немедленного (EAGER) на отложенный (LAZY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;
}
