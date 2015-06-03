package mps.repositories;


import mps.komponenten.supplier.entities.Supplier;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface SupplierRepository extends PagingAndSortingRepository<Supplier, Long>  {
	
	Supplier findByName(String name);
	Supplier findByID(long id);

}




	
