package com.suzhy.voyager.core.repository;

import com.suzhy.voyager.core.dto.Book;

public interface BookRepository {
	Book getByIsbn(String isbn);
}
