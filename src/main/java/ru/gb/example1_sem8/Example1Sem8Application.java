package ru.gb.example1_sem8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.gb.example1_sem8.entity.Book;
import ru.gb.example1_sem8.repository.BookRepository;

@SpringBootApplication
public class Example1Sem8Application implements CommandLineRunner  {

	@Autowired
	private final BookRepository bookRepository;

	public Example1Sem8Application(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Example1Sem8Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("Воина и мир", "Л.Н.Толстой");
		Book book2 = new Book("Каитанская дочька", "А.С.Пушкин");

		bookRepository.save(book1);
		bookRepository.save(book2);
	}

}
