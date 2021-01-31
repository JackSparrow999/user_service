package com.ykn.user_service.repositories;

import com.ykn.user_service.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
