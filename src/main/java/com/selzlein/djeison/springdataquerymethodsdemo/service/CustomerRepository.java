package com.selzlein.djeison.springdataquerymethodsdemo.service;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selzlein.djeison.springdataquerymethodsdemo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Set<Customer> findByBirthdayBetween(LocalDate startDate, LocalDate endDate);

	Set<Customer> findByFirstNameAndLastName(String firstName, String lastName);
	
	Set<Customer> findFirst2ByLastName(String lastName);
	
	Stream<Customer> readAllByLastNameNotNull();

	Set<Customer> findByAddress_ZipCode(String zipCode);

	@EntityGraph(attributePaths = "address")
	Set<Customer> findWithAddressByAddress_ZipCode(String zipCode);

}
