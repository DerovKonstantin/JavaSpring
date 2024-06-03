package ru.gb.example1_sem8.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.extern.slf4j.Slf4j;
import ru.gb.example1_sem8.entity.Book;
import ru.gb.example1_sem8.repository.BookRepository;
import ru.gb.example1_sem8.util.CustomResponse;
import ru.gb.example1_sem8.util.CustomStatus;

@Service
@Slf4j
public class BookService {

	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public CustomResponse<Book> getAll() {
		List<Book> books;
		/*try { // Сокращение коа с применеием AOP
			log.info("Попытка получить все книги");*/
			books = bookRepository.findAll();
		/*} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			return new CustomResponse<>(null, CustomStatus.EXCEPTION);
		}
		log.info("Все книги получены");*/
		return new CustomResponse<>(books, CustomStatus.SUCCESS);
	}

	public CustomResponse<Book> getBookByTitle(String title) {
		Book book;
		/*try {
			log.info("Пытаемся получить книгу с названием {}", title);*/
			book = bookRepository.findBookByTitle(title).orElseThrow();
		/*} catch (NoSuchElementException e) {
			log.error(e.getMessage(), e);
			return new CustomResponse<>(null, CustomStatus.NOT_FOUND);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new CustomResponse<>(null, CustomStatus.EXCEPTION);
		}
		log.info("Кгига с названием {} получена", title);*/
		return new CustomResponse<>(Stream.of(book).collect(Collectors.toList()), CustomStatus.SUCCESS);
	}

	public CustomResponse<Book> addBook(Book book) {
		Book newBook;
		/*try {
			log.info("Попытка добавить книгу с названием {}", book.getTitle());*/
			newBook = bookRepository.save(book);
		/*} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new CustomResponse<>(null, CustomStatus.EXCEPTION);
		}
		log.info("Книга с названием {} добавлена", book.getTitle());*/
		return new CustomResponse<>(Stream.of(newBook).collect(Collectors.toList()), CustomStatus.SUCCESS);
	}
}
