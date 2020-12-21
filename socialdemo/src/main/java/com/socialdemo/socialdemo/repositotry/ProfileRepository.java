package com.socialdemo.socialdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialdemo.socialdemo.entity.Profile;


@Repository
public interface ProfileRepository extends JpaRepository<Profile,String> {
	
	@Query(value = "SELECT * FROM employee_profile WHERE techcode = :techcode", nativeQuery = true)
	List<Profile> findByProfile(@Param("techcode")String techcode);
	

}
