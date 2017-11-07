package com.selzlein.djeison.springdataquerymethodsdemo.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selzlein.djeison.springdataquerymethodsdemo.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	Set<Address> findByZipCode(String zipCode);

	Set<Address> findByStreetIgnoreCaseContaining(String street);
	
	Optional<Address> findFirstByZipCodeOrStreetAllIgnoreCaseOrderByZipCodeDesc(String zipCode, String street);

}
