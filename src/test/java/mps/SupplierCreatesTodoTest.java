package mps;

import mps.komponenten.supplier.entities.Supplier;
import mps.repositories.SupplierRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SupplierCreatesTodoTest.ContextConfiguration.class)
public class SupplierCreatesTodoTest {

	@ComponentScan(basePackages = "mps")
	@Configuration
    static class ContextConfiguration {}

	@Autowired
	private SupplierRepository supRepo;
	
    @Test
    public void createTodo() {
    	Supplier supplier = new Supplier();
    	String name = "Wagner Traktoren Manufaktur GmbH";
    	supplier.setName(name);
    	supplier.setAdress("Waldstraße 12, in 27711 OHZ, Tel. 020-32442239");
    	supRepo.save(supplier);
    	
    	Supplier s2 = supRepo.findByName(name);
    	
    	Assert.isTrue(s2.equals(supplier));
    }

}


