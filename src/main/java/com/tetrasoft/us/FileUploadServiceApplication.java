package com.tetrasoft.us;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tetrasoft.us.example.Book;
import com.tetrasoft.us.example.BookCategory;
import com.tetrasoft.us.example.BookCategoryRepository;

@SpringBootApplication
public class FileUploadServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadServiceApplication.class, args);
	}
	@Autowired
	    private BookCategoryRepository bookCategoryRepository;

//	@PostConstruct
	public void save() {
		final BookCategory categoryA = new BookCategory("Category A");
        List<Book> bookAs = new ArrayList<>();
        bookAs.add(new Book("Book A1", categoryA));
        bookAs.add(new Book("Book A2", categoryA));
        bookAs.add(new Book("Book A3", categoryA));
        categoryA.setBooks(bookAs);
        bookCategoryRepository.save(categoryA);
		
	}

}
