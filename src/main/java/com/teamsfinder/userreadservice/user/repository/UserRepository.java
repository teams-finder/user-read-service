package com.teamsfinder.userreadservice.user.repository;

import com.teamsfinder.userreadservice.user.dto.UserResponseDto;
import com.teamsfinder.userreadservice.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.username LIKE %:username%")
    List<User> findUsersByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.keyCloakId = :keycloakId")
    Optional<User> findUserByKeyCloakId(String keycloakId);
}
