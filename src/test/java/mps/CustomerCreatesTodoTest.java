package mps;


import mps.komponenten.customer.entities.Customer;
import mps.repositories.CustomerRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CustomerCreatesTodoTest.ContextConfiguration.class)
public class CustomerCreatesTodoTest {

	@ComponentScan(basePackages = "mps")
	@Configuration
    static class ContextConfiguration {}

	@Autowired
	private CustomerRepository custRepo;
	
    @Test
    public void createTodo() {
    	Customer customer = new Customer();
    	customer.setLastname("Herrmann");
    	customer.setName("Tim");
    	custRepo.save(customer);
    	
    	Customer c2 = custRepo.findByLastname("Herrmann");
    	
    	
    	Assert.isTrue(c2.equals(customer));
    }
}


