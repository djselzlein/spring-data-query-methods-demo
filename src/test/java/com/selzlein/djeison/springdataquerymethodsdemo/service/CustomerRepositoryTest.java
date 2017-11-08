package com.selzlein.djeison.springdataquerymethodsdemo.service;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Stream;

import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.selzlein.djeison.springdataquerymethodsdemo.model.Customer;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void shouldFindAll() {
		assertThat(customerRepository.findAll(), hasSize(4));
	}

	@Test
	public void shouldFindByBirthdayBetween() {
		assertThat(customerRepository.findByBirthdayBetween(LocalDate.of(1980, 1, 1), LocalDate.of(1986, 1, 1)),
				hasSize(2));
	}

	@Test
	public void shouldFindByFirstNameAndLastName() {
		assertThat(customerRepository.findByFirstNameAndLastName("John", "Doe"), hasSize(1));
	}

	@Test
	public void shouldFindFirst2ByLastName() {
		assertThat(customerRepository.findFirst2ByLastName("Doe"), hasSize(2));
	}

	@Test
	public void shouldStreamAllByLastNameNotNull() {
		try (Stream<Customer> customers = customerRepository.readAllByLastNameNotNull()) {
			customers.forEach(customer -> {
				assertNotNull(customer);
				assertNotNull(customer.getId());
			});
		}
	}

	@Test
	public void shouldFindByAddressZipCode() {
		Set<Customer> customers = customerRepository.findByAddress_ZipCode("12345");

		assertThat(customers, hasSize(2));
		assertFalse(Hibernate.isInitialized(customers.stream().findAny().get().getAddress()));
	}

	@Test
	public void shouldFindWithAddressByAddressZipCode() {
		Set<Customer> customers = customerRepository.findWithAddressByAddress_ZipCode("12345");

		assertThat(customers, hasSize(2));
		assertTrue(Hibernate.isInitialized(customers.stream().findAny().get().getAddress()));
	}
}
