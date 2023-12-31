package com.lithan.jumpstart.repository;

import com.lithan.jumpstart.constraint.ERole;
import com.lithan.jumpstart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    boolean existsByEmailAndRole(String email, ERole role);
    boolean existsByEmailAndIsActive(String email, boolean isActive);
    User findByUuid(String uuid);
    List<User> findAllByRole(ERole role);
}
