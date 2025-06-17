package com.example.campusnest.repository;

import com.example.campusnest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Additional query methods can be defined here if needed.
    // For example, to find a user by email:
    User findByEmail(String email);

    boolean existsByEmail(String email);
}
