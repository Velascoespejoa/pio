package com.velascoespejo.pio.repost;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.velascoespejo.pio.user.User;
import com.velascoespejo.pio.post.Post;


public interface RepostRepository  extends JpaRepository<Repost, Long>{

    Optional<Repost> findByUserAndPost(User user , Post post);

    boolean existsByUserAndPost(User user, Post post);

    long countByPostId(Long postId);
}
