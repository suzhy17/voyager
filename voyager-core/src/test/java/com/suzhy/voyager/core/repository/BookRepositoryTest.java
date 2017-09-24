package com.suzhy.voyager.core.repository;

import com.suzhy.voyager.core.application.CoreApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=CoreApplication.class)
public class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void test() throws InterruptedException {

		System.out.println(".... Fetching books");
		System.out.println("isbn-1 -->" + bookRepository.getByIsbn("isbn-1"));
		Thread.sleep(1000L);
		System.out.println("isbn-1 -->" + bookRepository.getByIsbn("isbn-1"));
		Thread.sleep(1000L);
		System.out.println("isbn-1 -->" + bookRepository.getByIsbn("isbn-1"));
		Thread.sleep(1000L);
		System.out.println("isbn-1 -->" + bookRepository.getByIsbn("isbn-1"));
		Thread.sleep(5000L);
		System.out.println("isbn-1 -->" + bookRepository.getByIsbn("isbn-1"));
		Thread.sleep(1000L);
		System.out.println("isbn-1 -->" + bookRepository.getByIsbn("isbn-1"));
	}
}
