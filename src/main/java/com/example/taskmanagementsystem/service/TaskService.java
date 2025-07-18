package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.entity.Status;
import com.example.taskmanagementsystem.entity.Task;
import com.example.taskmanagementsystem.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService{
    private final TaskRepository taskRepository;

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public List<Task> findByPriorityTrue(Sort sort) {
        return taskRepository.findByPriorityTrue(sort);
    }

    public List<Task> findByPriorityFalse(Sort sort) {
        return taskRepository.findByPriorityFalse(sort);
    }

    public List<Task> findByStatus(Status status) {
        return taskRepository.findByStatus(status);
    }

    public List<Task> findByDescriptionContaining(String description) {
        return taskRepository.findByDescriptionContaining(description);
    }

    public List<Task> findByTitleContaining(String description) {
        return taskRepository.findByTitleContaining(description);
    }

    public List<Task> findByDate(LocalDateTime date) {
        return taskRepository.findByDateBetween(date.toLocalDate().atStartOfDay(), date.toLocalDate().atTime(23, 59, 59));
    }

    public List<Task> findByDateAndStatus(LocalDateTime date, Status status) {
        return taskRepository.findByDateBetweenAndStatus(date.toLocalDate().atStartOfDay(), date.toLocalDate().atTime(23, 59, 59), status);
    }

    public List<Task> findByPriorityAndStatus(Boolean priority, Status status) {
        return taskRepository.findByPriorityAndStatus(priority, status);
    }

    public List<Task> findByDateBefore(LocalDateTime date) {
        return taskRepository.findByDateBefore(date.toLocalDate().atStartOfDay());
    }

    public List<Task> findByDateAfter(LocalDateTime date) {
        return taskRepository.findByDateAfter(date.toLocalDate().atStartOfDay());
    }
}
