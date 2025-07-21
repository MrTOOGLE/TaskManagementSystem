package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.entity.Status;
import com.example.taskmanagementsystem.entity.Task;
import com.example.taskmanagementsystem.repository.TaskRepository;
import com.example.taskmanagementsystem.specification.TaskSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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

    public List<Task> findByDate(LocalDateTime date) {
        return taskRepository.findByDateBetween(date.toLocalDate().atStartOfDay(), date.toLocalDate().atTime(23, 59, 59));
    }

    public List<Task> findByDateBefore(LocalDateTime date) {
        Sort sort = Sort.by("date").ascending();
        return taskRepository.findByDateBefore(date.toLocalDate().atStartOfDay(), sort);
    }

    public List<Task> findByDateAfter(LocalDateTime date) {
        Sort sort = Sort.by("date").ascending();
        return taskRepository.findByDateAfter(date.toLocalDate().atStartOfDay(), sort);
    }

    public List<Task> findByDateBetween(LocalDateTime start, LocalDateTime end) {
        return taskRepository.findByDateBetween(start, end);
    }

    public List<Task> findTasks(String title, Status status, Boolean priority) {
        Specification<Task> spec = TaskSpecification
                .hasTitle(title)
                .and(TaskSpecification.hasStatus(status))
                .and(TaskSpecification.hasPriority(priority));
        Sort sort = Sort.by("priority").descending()
                .and(Sort.by("date").ascending());

        return taskRepository.findAll(spec, sort);
    }
}
