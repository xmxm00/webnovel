package com.numble.webnovel.entity.repository;

import com.numble.webnovel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByEmail(String email);
}
