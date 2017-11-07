package com.selzlein.djeison.springdataquerymethodsdemo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.selzlein.djeison.springdataquerymethodsdemo.app.model.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address implements Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String street;

	private String zipCode;

	@OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
	private Set<Customer> customer;

}
