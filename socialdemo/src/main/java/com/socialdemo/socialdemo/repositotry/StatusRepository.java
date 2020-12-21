package com.socialdemo.socialdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialdemo.socialdemo.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, String> {
	
	@Query(value = "SELECT * FROM employee_profile WHERE techcode IN :techcode", nativeQuery = true)
	String getStatus(@Param("techcode")String techcode); 
		
	
}
