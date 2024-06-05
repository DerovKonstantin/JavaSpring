package ru.gb.microservice2_book.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.gb.microservice2_book.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	Optional<Book> findBookByTitle(String title);
}
