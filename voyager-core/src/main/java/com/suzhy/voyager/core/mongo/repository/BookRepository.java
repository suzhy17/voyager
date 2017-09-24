package com.suzhy.voyager.core.mongo.repository;

import com.suzhy.voyager.core.mongo.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
	Book findByTitleLike(String title);

	List<Book> findByAuthor(String author);

	@Query(value = "{tags: {$in: ['?0']}}")
	List<Book> findByTag(String tag);

	@Query(value = "{tags: {$in: ?0}}")
	List<Book> findByTags(String... tags);

	@Query(value = "{price.discountedPrice: {$lte: ?0}}")
	List<Book> findByPriceLessThan(Integer discountedPrice);

	@Query(value = "{issueYear: {$lte: ?0, $gte: ?1}}")
	List<Book> findByIssueYearBetween(Integer startYear, Integer endYear);
}
