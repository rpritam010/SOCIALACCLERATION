package com.socialdemo.socialdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class EngineerDetailResponse {
	
	private String techCode;
	
	private String skillMapping;
	
	private String taskType ;
	
	private String wmPin;
	
	private String description1;
	
	private String description2;
	
	private String startTime;
	
	private String endTime;
	
	public EngineerDetailResponse() {
			}

	public String getTechCode() {
		return techCode;
	}

	public void setTechCode(String techCode) {
		this.techCode = techCode;
	}

	public String getSkillMapping() {
		return skillMapping;
	}

	public void setSkillMapping(String skillMapping) {
		this.skillMapping = skillMapping;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getWmPin() {
		return wmPin;
	}

	public void setWmPin(String wmPin) {
		this.wmPin = wmPin;
	}

	public String getDescription1() {
		return description1;
	}

	public void setDescription1(String description1) {
		this.description1 = description1;
	}

	public String getDescription2() {
		return description2;
	}

	public void setDescription2(String description2) {
		this.description2 = description2;
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

	@Override
	public String toString() {
		return "EngineerDetailResponse [techCode=" + techCode + ", skillMapping=" + skillMapping + ", taskType="
				+ taskType + ", wmPin=" + wmPin + ", description1=" + description1 + ", description2=" + description2
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	public EngineerDetailResponse(String techCode, String skillMapping,String taskType ,String wmPin,String description1,String description2,
	String startTime,String endTime) {
		
		this.techCode = techCode;
		this.skillMapping=skillMapping;
		this.taskType=taskType;
		this.wmPin=wmPin;
		this.description1=description1;
		this.description2=description2;
		this.startTime=startTime;
		this.endTime=endTime;
		
	}

}
