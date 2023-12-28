package project_part2.entities.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_part2.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findByEmailAndPassword(String email, String password);
	
	Customer findByEmail(String email); 
	
	//Customer findCustomerByEmail(String email);
}
