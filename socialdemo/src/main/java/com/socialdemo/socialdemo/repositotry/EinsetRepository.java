package com.socialdemo.socialdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialdemo.socialdemo.entity.Einset;

@Repository
public interface EinsetRepository extends JpaRepository<Einset, Integer> {
	
	@Query("SELECT ein.pin FROM Einset ein WHERE ein.techcode=:techcode")
	List<String> findAllById(@Param("techcode") String techcode);

}
