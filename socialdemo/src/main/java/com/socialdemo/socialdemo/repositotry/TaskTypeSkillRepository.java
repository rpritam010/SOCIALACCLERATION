package com.socialdemo.socialdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialdemo.socialdemo.entity.TaskTypeSkill;

@Repository
public interface TaskTypeSkillRepository extends JpaRepository<TaskTypeSkill, Integer> {
	
	@Query("SELECT tts.skillcode FROM TaskTypeSkill tts WHERE tts.tasktype=:tasktype")
	List<String> getPrimarySkill(@Param("tasktype") String tasktype);

}
