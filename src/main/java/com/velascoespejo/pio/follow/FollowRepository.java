package com.velascoespejo.pio.follow;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.velascoespejo.pio.user.User;

// FollowRepository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    boolean existsBySeguidorAndSeguido(User seguidor, User seguido);

    Optional<Follow> findBySeguidorAndSeguido(User seguidor, User seguido);

    // contar sin cargar objetos
    long countBySeguidorId(Long seguidorId);
    long countBySeguidoId(Long seguidoId);

    // feed: IDs de usuarios que sigo
    @Query("SELECT f.seguido.id FROM Follow f WHERE f.seguidor.id = :id")
    List<Long> findSeguidosIdsBySeguidorId(@Param("id") Long id);

    @Query("SELECT f.seguidor.id FROM Follow f WHERE f.seguido.id = :id")
    List<Long> findSeguidoresIdsBySeguidoId(@Param("id") Long id);
}