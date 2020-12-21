package com.socialdemo.socialdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialdemo.socialdemo.entity.EngineerDetails;
@Repository
public interface EngineerDetailsRepository extends JpaRepository<EngineerDetails,Integer> {
	
	@Query(value = "SELECT * FROM engineer_details WHERE techcode = :techcode", nativeQuery = true)
	
	List<EngineerDetails> findByEngineerDetails(@Param("techcode") String techcode);
	//EngineerDetails findByEngineerDetails(@Param("techCode") String techCode);

}
