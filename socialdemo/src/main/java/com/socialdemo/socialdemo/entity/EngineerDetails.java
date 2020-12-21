/**
 * @author Pritam Raj
 *
 * 07-Dec-2020
 * @socialdemoSocialAccleration
 */

package com.socialdemo.socialdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "engineer_details")
public class EngineerDetails {
	//Atributes of the tables based on the requirement
	@Id
    @Column(name = "edid", nullable = false, updatable = false)
	private int edid;
	
	@Column(name = "techcode")
	private String techcode;
	
	@Column(name = "skillmapping")
	private String skillmapping;
	
	@Column(name = "tasktype")
	private String tasktype ;
	
	@Column(name = "wmpin")
	private String wmPin;
	
	@Column(name = "description1")
	private String description1;
	
	@Column(name = "description2")
	private String description2;
	
	@Column(name = "starttime")
	private String starttime;
	
	@Column(name = "endtime")
	private String endtime;

	public String getTechcode() {
		return techcode;
	}

	public void setTechcode(String techcode) {
		this.techcode = techcode;
	}

	public String getSkillmapping() {
		return skillmapping;
	}

	public void setSkillmapping(String skillmapping) {
		this.skillmapping = skillmapping;
	}

	public String getTasktype() {
		return tasktype;
	}

	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
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

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	@Override
	public String toString() {
		return "EngineerDetails [techcode=" + techcode + ", skillmapping=" + skillmapping + ", tasktype=" + tasktype
				+ ", wmPin=" + wmPin + ", description1=" + description1 + ", description2=" + description2
				+ ", starttime=" + starttime + ", endtime=" + endtime + "]";
	}

	
	}
