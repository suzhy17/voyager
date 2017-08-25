package com.suzhy.voyager.core.repository;

import com.suzhy.voyager.core.application.CoreApplication;
import com.suzhy.voyager.core.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=CoreApplication.class)
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository repository;

	@Test
	public void test() {
		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}

	}

	@Test
	public void testExample() throws Exception {
		this.repository.save(new Customer("Youngsu", "Han"));
		Customer customer = this.repository.findByFirstName("Youngsu");
		assertThat(customer.firstName).isEqualTo("Youngsu");
	}
}
