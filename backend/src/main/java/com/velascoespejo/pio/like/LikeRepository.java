package com.velascoespejo.pio.like;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.velascoespejo.pio.user.User;
import com.velascoespejo.pio.post.Post;


public interface LikeRepository  extends JpaRepository<Like, Long>{

    Optional<Like> findByUserAndPost(User user , Post post);

    boolean existsByUserAndPost(User user, Post post);

    long countByPostId(Long postId);
}
