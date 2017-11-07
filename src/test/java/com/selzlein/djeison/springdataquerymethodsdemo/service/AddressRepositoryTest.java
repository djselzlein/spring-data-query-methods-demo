package com.selzlein.djeison.springdataquerymethodsdemo.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.selzlein.djeison.springdataquerymethodsdemo.model.Address;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AddressRepositoryTest {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Test
	public void shouldFindAll() {
		assertThat(addressRepository.findAll(), hasSize(3));
	}
	
	@Test
	public void shouldFindByZipCode() {
		assertThat(addressRepository.findByZipCode("11111"), hasSize(1));
	}
	
	@Test
	public void shouldFindByStreetContaining() {
		assertThat(addressRepository.findByStreetIgnoreCaseContaining("street"), hasSize(2));
	}

	@Test
	public void shouldFindFirstByZipCodeOrStreet() {
		Optional<Address> address = addressRepository.findFirstByZipCodeOrStreetAllIgnoreCaseOrderByZipCodeDesc("55555", "main st");
		assertTrue(address.isPresent());
		assertThat(address.get().getId(), equalTo(3L));
		assertThat(address.get().getStreet(), equalTo("5th Street"));
	}
	
}
