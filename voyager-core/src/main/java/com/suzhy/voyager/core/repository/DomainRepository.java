package com.suzhy.voyager.core.repository;

import com.suzhy.voyager.core.domain.Domain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface DomainRepository extends MongoRepository<Domain, Long>, DomainRepositoryCustom {

	Domain findFirstByDomain(String domain);

	Domain findByDomainAndDisplayAds(String domain, boolean displayAds);

	//Supports native JSON query string
	@Query("{domain:'?0'}")
	Domain findCustomByDomain(String domain);

	@Query("{domain: { $regex: ?0 } })")
	List<Domain> findCustomByRegExDomain(String domain);

}