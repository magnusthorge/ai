package mps.repositories;

import mps.komponenten.customer.entities.Customer;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

	Customer findByLastname(String lastname);

}
