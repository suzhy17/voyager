package com.suzhy.voyager.core.mongo.repository;

import com.suzhy.voyager.core.application.CoreApplication;
import com.suzhy.voyager.core.mongo.domain.Book;
import com.suzhy.voyager.core.mongo.domain.Price;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes=CoreApplication.class)
public class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;

	@Before
	public void setup() {
		bookRepository.save(new Book(1, "A0001","spring5", "Smith", 2011, new Price(10000, 8000), Arrays.asList("스프링", "스미스", "spring", "program")));
		bookRepository.save(new Book(2, "A0002","html5", "charles", 2012, new Price(20000, 16000), Arrays.asList("html5", "charles", "web")));
		bookRepository.save(new Book(3, "A0003","html4", "kim", 2013, new Price(30000, 24000), Arrays.asList("html4", "kim", "web")));
		bookRepository.save(new Book(4, "A0004","css3", "han", 2014, new Price(40000, 32000), Arrays.asList("css3", "html5", "han", "web", "program")));
		bookRepository.save(new Book(5, "A0005","javascript", "lee", 2015, new Price(50000, 40000), Arrays.asList("javascript", "web", "program")));
	}

	@After
	public void destroy() {
		//bookRepository.deleteAll();
	}

	@Test
	public void test_findAll() {
		// given

		// when
		List<Book> books = bookRepository.findAll();
		log.info("books.size()={}", books.size());

		// then
		assertEquals(books.size(), 5);
	}

	@Test
	public void test_findByTitleLike() {
		// given
		String title = "spring";

		// when
		Book book = bookRepository.findByTitleLike(title);
		log.info("book={}", book);

		// then
		assertNotNull(book);
		assertTrue(book.getTitle().contains(title));
	}

	@Test
	public void test_findByTag() {
		// given
		String tag = "program";

		// when
		List<Book> books = bookRepository.findByTag(tag);
		books.forEach(book -> log.info("book={}", book));

		long filteredCount = books.stream().filter(book -> book.getTags().contains(tag)).count();
		log.info("filtered={}", filteredCount);

		// then
		assertTrue(books.size() == filteredCount);
		assertTrue(books.stream().findAny().orElseGet(null).getTags().contains(tag));
	}

	@Test
	public void test_findByTags() {
		// given
		String tag1 = "html4";
		String tag2 = "html5";

		// when
		List<Book> books = bookRepository.findByTags(tag1, tag2);
		books.forEach(book -> log.info("book={}", book));

		long filteredCount = books.parallelStream().filter(book -> book.getTags().contains(tag1) || book.getTags().contains(tag2)).count();
		List<String> bookTags = books.stream().findAny().orElseGet(null).getTags();

		// then
		assertTrue(books.size() == filteredCount);
		assertTrue(bookTags.contains(tag1) || bookTags.contains(tag2));
	}

	@Test
	public void test_findByPriceLessThan() {
		// given
		Integer discountedPrice = 30000;

		// when
		List<Book> books = bookRepository.findByPriceLessThan(discountedPrice);
		books.forEach(book -> log.info("book={}", book));

		long filteredCount = books.parallelStream().filter(book -> book.getPrice().getDiscountedPrice() <= discountedPrice).count();

		// then
		assertTrue(books.size() == filteredCount);
	}

	@Test
	public void test_findByIssueYearBetween() {
		// given
		Integer startYear = 2012;
		Integer endYear = 2014;

		// when
		List<Book> books = bookRepository.findByIssueYearBetween(startYear, endYear);
		books.forEach(book -> log.info("book={}", book));

		long filteredCount = books.parallelStream().filter(book -> startYear <= book.getIssueYear() && book.getIssueYear() <= endYear).count();

		// then
		assertTrue(books.size() == filteredCount);
	}
}
