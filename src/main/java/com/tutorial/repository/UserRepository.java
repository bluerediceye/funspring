package com.tutorial.repository;

import com.tutorial.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mli on 16/01/15.
 */

public interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository {
}
