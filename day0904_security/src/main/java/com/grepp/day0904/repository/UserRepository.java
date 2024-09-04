package com.grepp.day0904.repository;




import com.grepp.day0904.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    // save
    UserEntity findByUsernameAndPassword(String username, String password);
}