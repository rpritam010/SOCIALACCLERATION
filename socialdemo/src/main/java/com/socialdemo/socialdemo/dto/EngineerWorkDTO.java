package com.socialdemo.socialdemo.dto;

import java.util.List;

public class EngineerWorkDTO {
	
	private String wm_pin;
	
	private String Techcode;
	
	private String taskDescription;
	
	private String startTime;
	
	private String endTime;
	
	private String taskType;
	
	private List<SkillMapping> skillMapping;

	public String getWm_pin() {
		return wm_pin;
	}

	public void setWm_pin(String wm_pin) {
		this.wm_pin = wm_pin;
	}

	public String getTechcode() {
		return Techcode;
	}

	public void setTechcode(String techcode) {
		Techcode = techcode;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public List<SkillMapping> getSkillMapping() {
		return skillMapping;
	}

	public void setSkillMapping(List<SkillMapping> skillMapping) {
		this.skillMapping = skillMapping;
	}
	
	
}
