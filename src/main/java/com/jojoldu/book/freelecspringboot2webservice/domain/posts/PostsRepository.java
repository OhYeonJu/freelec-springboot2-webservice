package com.jojoldu.book.freelecspringboot2webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> { // JpaRepository를 상속하면 기본 CRUD 메소드가 생성된다. , Entity클래스와 기본 Repository는 함께 움직여야 하므로 도메인 패키지에서 함께 관리.
    @Query("SELECT  p from Posts p order by p.id desc")
    List<Posts> findAllDesc();
}
