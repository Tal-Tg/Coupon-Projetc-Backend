package project_part2.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_part2.entities.Company;

@Repository
public interface CompanyRepositroy extends JpaRepository<Company, Integer>{

	Company findCompanyByEmailAndPassword(String email, String password);
	
	Company findByEmail(String email);
	
	Company findByName(String name);
	
	
	
}
