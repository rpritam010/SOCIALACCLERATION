package com.socialdemo.socialdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialdemo.socialdemo.entity.TaskType;

@Repository
public interface TaskTypeRepository extends JpaRepository<TaskType,Integer> {
	
	@Query("SELECT tt FROM TaskType tt WHERE tt.tasktype = :tasktype")
	List<TaskType> getDescription(@Param("tasktype")String tasktype);

}
