package com.house.start.domain;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Like {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post; // 게시물

    @ManyToOne
    @JoinColumn(name = "consumer_id")
    private Consumer consumer; // 작성자
}