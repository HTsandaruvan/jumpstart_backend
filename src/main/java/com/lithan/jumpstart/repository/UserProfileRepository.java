package com.lithan.jumpstart.repository;

import com.lithan.jumpstart.entity.User;
import com.lithan.jumpstart.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository  extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByUser(User user);
}
