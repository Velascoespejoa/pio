package com.velascoespejo.pio.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	Optional<User> findByNick(String nick);

    List<User> findByNickContainingIgnoreCase(String nick);
}
