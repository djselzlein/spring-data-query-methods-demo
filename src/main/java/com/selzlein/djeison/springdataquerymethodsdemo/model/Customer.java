package com.selzlein.djeison.springdataquerymethodsdemo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.selzlein.djeison.springdataquerymethodsdemo.app.model.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Customer implements Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;

	private String lastName;

	private LocalDate birthday;

	@ManyToOne(fetch = FetchType.LAZY)
	private Address address;

}
