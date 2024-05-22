package ru.gb.homework_sem6.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.gb.homework_sem6.model.Task;

// Подсказка:
//     Репозиторий насладует JpaRepository<Note, Long>. 
// В репозитории добавляем метод Optional<Note> findById(Long id);

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long> {
    Optional<Task> findById(Long id);
}
