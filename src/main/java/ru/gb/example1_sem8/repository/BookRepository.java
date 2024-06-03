package ru.gb.example1_sem8.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.gb.example1_sem8.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	// по умолчанию CRUD методы
	// создадим свой метод для получения по названию
	Optional<Book> findBookByTitle(String title);
}
