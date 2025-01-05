package com.LiterAlura.VictCast.LiterAlura;

import com.LiterAlura.VictCast.LiterAlura.Controllers.BooksController;
import com.LiterAlura.VictCast.LiterAlura.Services.BooksServices;
import com.LiterAlura.VictCast.LiterAlura.View.BooksView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Autowired
	private BooksController booksController;

	@Override
	public void run(String... args) throws Exception {
		booksController.startMenu();
	}
}