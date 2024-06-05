package ru.gb.microservice2_book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.gb.microservice2_book.entity.Book;
import ru.gb.microservice2_book.service.BookService;
import ru.gb.microservice2_book.util.CustomResponse;

@RestController
@RequestMapping("/api")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/books")
	public CustomResponse<Book> getAll() {
		return bookService.getAll();
	}
	
	@GetMapping("/books/{title}")
	public CustomResponse<Book> getBookByTitle(@PathVariable("title") String title) {
		return bookService.getBookByTitle(title);
	}

	@PostMapping("/books")
	public CustomResponse<Book> addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
}
