package com.example.taskmanagementsystem.repository;

import com.example.taskmanagementsystem.entity.Status;
import com.example.taskmanagementsystem.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {
    List<Task> findByDateBetween(LocalDateTime start, LocalDateTime end);
    List<Task> findByDateBefore(LocalDateTime date);
    List<Task> findByDateAfter(LocalDateTime date);
}
