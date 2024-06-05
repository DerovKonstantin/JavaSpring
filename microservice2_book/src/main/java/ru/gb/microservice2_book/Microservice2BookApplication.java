package ru.gb.microservice2_book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.gb.microservice2_book.entity.Book;
import ru.gb.microservice2_book.repository.BookRepository;

@SpringBootApplication
public class Microservice2BookApplication implements CommandLineRunner  {

	@Autowired
	private final BookRepository bookRepository;

	public Microservice2BookApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(Microservice2BookApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("Воина и мир", "Л.Н.Толстой");
		Book book2 = new Book("Каитанская дочька", "А.С.Пушкин");

		bookRepository.save(book1);
		bookRepository.save(book2);
	}

}
