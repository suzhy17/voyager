package com.suzhy.voyager.core.cache.repository;

import com.suzhy.voyager.core.dto.BookDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class BookRepositoryImpl implements BookRepository {

	@Override
	@Cacheable("books")
	public BookDto getByIsbn(String isbn) {
		simulateSlowService();
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