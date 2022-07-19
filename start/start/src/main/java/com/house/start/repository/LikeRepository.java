package com.house.start.repository;

import com.house.start.domain.Like;
import com.house.start.domain.Member;
import com.house.start.domain.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {

    List<Like> findByMember(Member member);


}
