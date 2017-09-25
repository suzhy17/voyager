package com.suzhy.voyager.core.cache.repository;

import com.suzhy.voyager.core.dto.BookDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BookRepositoryImpl implements BookRepository {

	@Override
	@Cacheable("booksCache")
	public BookDto getByIsbn(String isbn) {
		log.info(" non-cache run");
		return new BookDto(isbn, "Some book");
	}

	// Don't do this at home
	private void simulateSlowService() {
		try {
			long time = 3000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

}