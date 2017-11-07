package com.selzlein.djeison.springdataquerymethodsdemo.service;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selzlein.djeison.springdataquerymethodsdemo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Set<Customer> findByBirthdayBetween(LocalDate startDate, LocalDate endDate);

	Set<Customer> findByAddress_ZipCode(String zipCode);

	@EntityGraph(attributePaths = "address")
	Set<Customer> findWithAddressByAddress_ZipCode(String zipCode);

}
