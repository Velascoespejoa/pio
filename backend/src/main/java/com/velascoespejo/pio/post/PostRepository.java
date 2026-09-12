package com.velascoespejo.pio.post;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepository extends JpaRepository<Post, Long> {


    @Query("""
        SELECT t
        FROM Post t
        WHERE t.user.id = :userId
        OR t.user.id IN (
            SELECT f.seguido.id
            FROM Follow f
            WHERE f.seguidor.id = :userId
        )
        ORDER BY t.createAt DESC
    """)
    Page<Post> findTimeline(@Param("userId") Long userId, Pageable pageable);

    
}
