package com.socialdemo.socialdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialdemo.socialdemo.entity.JobDetails;

@Repository
public interface JobDetailsRepository extends JpaRepository<JobDetails, Integer> {
	
	@Query("SELECT jd FROM JobDetails jd WHERE jd.pin=:pin")
	List<JobDetails> getTaskType(@Param("pin") String pin);
	
	@Query( "SELECT jd.skillcode FROM JobDetails jd FROM jd.tasktype=:tasktype")	
	List<String> getListOfSubSkills(@Param("tasktype") String tasktype);

}
