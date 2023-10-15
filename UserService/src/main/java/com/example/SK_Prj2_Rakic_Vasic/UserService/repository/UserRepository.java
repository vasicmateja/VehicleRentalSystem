package com.example.SK_Prj2_Rakic_Vasic.UserService.repository;

import com.example.SK_Prj2_Rakic_Vasic.UserService.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByFirstName (String name);

    Optional<User> findUserByEmailAndPassword(String email, String password);

}
