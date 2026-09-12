package com.velascoespejo.pio.post;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {


@Query("""
    SELECT t
    FROM Post t
    JOIN Follow f ON f.seguido.id = t.user.id
    WHERE f.seguidor.id = :userId
    ORDER BY t.createAt DESC
""")
List<Post> findTimeline(@Param("userId") Long userId);

    
}
