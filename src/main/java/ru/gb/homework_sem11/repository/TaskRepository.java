package ru.gb.homework_sem11.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.gb.homework_sem11.model.Task;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long> {
    Optional<Task> findById(Long id);
}
