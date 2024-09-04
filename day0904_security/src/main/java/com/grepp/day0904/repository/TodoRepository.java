package com.grepp.day0904.repository;



import com.grepp.day0904.model.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    List<TodoEntity> findByUsername(String username);
    TodoEntity findById(int id);
}
