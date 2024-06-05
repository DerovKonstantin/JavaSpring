package ru.gb.microservice2_book.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import ru.gb.microservice2_book.entity.Book;
import ru.gb.microservice2_book.repository.BookRepository;
import ru.gb.microservice2_book.util.CustomResponse;
import ru.gb.microservice2_book.util.CustomStatus;

@Service
public class BookService {

	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public CustomResponse<Book> getAll() {
		List<Book> books = bookRepository.findAll();
		return new CustomResponse<>(books, CustomStatus.SUCCESS);
	}

	public CustomResponse<Book> getBookByTitle(String title) {
		Book book = bookRepository.findBookByTitle(title).orElseThrow();
		return new CustomResponse<>(Stream.of(book).collect(Collectors.toList()), CustomStatus.SUCCESS);
	}

	public CustomResponse<Book> addBook(Book book) {
		Book newBook = bookRepository.save(book);
		return new CustomResponse<>(Stream.of(newBook).collect(Collectors.toList()), CustomStatus.SUCCESS);
	}
}