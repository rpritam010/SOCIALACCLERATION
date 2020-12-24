package com.socialdemo.socialdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_type")
public class TaskType {
	
	@Id
	@Column(name = "tt_id")
	private int id;
	
	@Column(name = "wm_id")
	private String wmid;
	
	@Column(name = "task_type")
	private String tasktype;
	
	@Column(name = "importance_class")
	private String importance;
	
	@Column(name = "job_category")
	private String jobcategory;
	
	@Column(name = "delete_allowed_ind")
	private String delete;
	
	@Column(name = "varibality_factor")
	private String variability;
	
	@Column(name = "class_of_work")
	private String classofwork;
	
	@Column(name = "interruptable")
	private String interruptable;
	
	@Column(name = " job_type")
	private String jobtype;
	
	@Column(name = "last_updated")
	private String lastupdated;
	
	@Column(name = "description_1")
	private String description1;
	
	@Column(name = "description_2")
	private String description2;

	public String getWmid() {
		return wmid;
	}

	public void setWmid(String wmid) {
		this.wmid = wmid;
	}

	public String getTasktype() {
		return tasktype;
	}

	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public String getJobcategory() {
		return jobcategory;
	}

	public void setJobcategory(String jobcategory) {
		this.jobcategory = jobcategory;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getVariability() {
		return variability;
	}

	public void setVariability(String variability) {
		this.variability = variability;
	}

	public String getClassofwork() {
		return classofwork;
	}

	public void setClassofwork(String classofwork) {
		this.classofwork = classofwork;
	}

	public String getInterruptable() {
		return interruptable;
	}

	public void setInterruptable(String interruptable) {
		this.interruptable = interruptable;
	}

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public String getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(String lastupdated) {
		this.lastupdated = lastupdated;
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

	@Override
	public String toString() {
		return "TaskType [wmid=" + wmid + ", tasktype=" + tasktype + ", importance=" + importance + ", jobcategory="
				+ jobcategory + ", delete=" + delete + ", variability=" + variability + ", classofwork=" + classofwork
				+ ", interruptable=" + interruptable + ", jobtype=" + jobtype + ", lastupdated=" + lastupdated
				+ ", description1=" + description1 + ", description2=" + description2 + "]";
	}
	

	
}
