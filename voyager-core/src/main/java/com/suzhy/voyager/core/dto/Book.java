package com.suzhy.voyager.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
	private String isbn;
	private String title;
}
