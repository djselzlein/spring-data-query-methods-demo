# Spring Data Query Methods Demo

[![Build Status](https://img.shields.io/travis/selzlein/spring-data-query-methods-demo.svg?style=flat-square)](https://travis-ci.org/selzlein/spring-data-query-methods-demo)

Use Spring Data to generate database query methods by method names.

## What for?

Spring Data repositories implement a strategy for generating database query methods from the method's names themselves.

Spring Data JpaRepository:

`interface JpaRepository<T, ID extends Serializable>`

Create an interface repository for your model by extending *JpaRepository* like this:

`interface AddressRepository extends JpaRepository<Address, Long>`

In your interface you can add method signatures following Spring Data Query Methods' strategy:

`Set<Customer> findByBirthdayBetween(LocalDate startDate, LocalDate endDate);`

`Set<Customer> findByAddress_ZipCode(String zipCode);`

By following this strategy, Spring Data will generate implementation for these methods and you will be able to use them without having to write a single [JPQL](https://docs.oracle.com/html/E13946_01/ejb3_langref.html) (Java Persistence Query Language) line nor the worst case, native [SQL](https://www.w3schools.com/sql/).

Check [tests in this project](https://github.com/selzlein/spring-data-query-methods-demo/tree/master/src/test/java/com/selzlein/djeison/springdataquerymethodsdemo/service) for a better comprehension.

See [this blog post](https://selzlein.github.io/2017/11/08/spring-data-query-methods-by-name/) for a complete guidance on implementing Spring Data Query Methods.

See [Spring Data documentation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details) for further details.

## Run

- Clone
- `mvn test`
