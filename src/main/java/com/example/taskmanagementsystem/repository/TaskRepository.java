package com.example.taskmanagementsystem.repository;

import com.example.taskmanagementsystem.entity.Status;
import com.example.taskmanagementsystem.entity.Task;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByPriorityTrue(Sort sort);
    List<Task> findByPriorityFalse();
    List<Task> findByStatus(Status status);
    List<Task> findByDateBetween(LocalDateTime start, LocalDateTime end);
    List<Task> findByDescriptionContaining(String description);
    List<Task> findByDateBetweenAndStatus(LocalDateTime start, LocalDateTime end, Status status);
    List<Task> findByTitleContaining(String title);
    List<Task> findByPriorityTrueAndStatus(Status status);
    List<Task> findByDateBefore(LocalDateTime date);
    List<Task> findByDateAfter(LocalDateTime date);
}
