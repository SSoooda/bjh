package com.bjh.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p " + "from Posts p " + "order by p.id desc ")
    Stream<Posts> findAllDesc ();

}
