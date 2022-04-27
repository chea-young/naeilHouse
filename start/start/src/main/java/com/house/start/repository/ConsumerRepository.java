package com.house.start.repository;

import com.house.start.domain.Admin;
import com.house.start.domain.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
    /*
    public List<String> findAllWith() {
        return em.createQuery("select c.id, c.cId, count(p.id) from Consumer c, Post p where c.id = p.consumer", String.class)
                .getResultList();
    }*/
//    public Optional<Consumer> findByCId(String cId);

    // 소비자 아이디로 조회
    Optional<Consumer> findBycId (String cId);



}
