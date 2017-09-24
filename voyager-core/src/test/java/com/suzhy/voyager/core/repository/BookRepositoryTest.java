package com.suzhy.voyager.core.repository;

import com.suzhy.voyager.core.application.TestApplication;
import com.suzhy.voyager.core.cache.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void test() {
		System.out.println(".... Fetching books");
		System.out.println("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
		System.out.println("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
		System.out.println("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
		System.out.println("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
		System.out.println("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
		System.out.println("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
	}
}
