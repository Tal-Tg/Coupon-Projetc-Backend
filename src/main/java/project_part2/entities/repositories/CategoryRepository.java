package project_part2.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project_part2.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	

}
