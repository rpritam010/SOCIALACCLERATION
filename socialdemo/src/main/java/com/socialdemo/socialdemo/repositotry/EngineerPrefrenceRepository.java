package com.socialdemo.socialdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialdemo.socialdemo.entity.EngineerPrefrence;

@Repository
public interface EngineerPrefrenceRepository extends JpaRepository<EngineerPrefrence, String> {
	
	//@Query(value = "SELECT * FROM employee_prefrence t WHERE skill_code IN :skillCode ORDER BY i_prefrence ASC", nativeQuery = true)
//	List<EngineerPrefrence> findByEngineerPrefrence(@Param("skillCode")List<String> skillCode);

	@Query(value = "SELECT * FROM employee_prefrence WHERE skill_code = skill_code AND i_prefrence <= 5  ORDER BY i_prefrence ASC", nativeQuery = true)
	List<EngineerPrefrence> findByEngineerPrefrence(@Param("skill_code")String skill_code);

}
