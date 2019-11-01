package com.books.bookcatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BookcatalogueApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BookcatalogueApplication.class, args);
	}

}
