package com.selzlein.djeison.springdataquerymethodsdemo.service;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Set;

import static org.hamcrest.Matchers.*;

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
	public void shouldFindByBirthday() {
		assertThat(customerRepository.findByBirthday(LocalDate.of(1985, 5, 5)), hasSize(1));
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
