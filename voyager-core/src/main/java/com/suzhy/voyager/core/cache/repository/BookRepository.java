package com.suzhy.voyager.core.cache.repository;

import com.suzhy.voyager.core.dto.BookDto;

public interface BookRepository {
	BookDto getByIsbn(String isbn);
}
