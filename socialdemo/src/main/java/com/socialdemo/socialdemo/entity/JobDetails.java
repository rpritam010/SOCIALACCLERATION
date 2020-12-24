package com.socialdemo.socialdemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javassist.SerialVersionUID;

@Entity
@Table(name = "job_details")
public class JobDetails implements Serializable {
		private static final long SerialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jd_id")
	private int jdid;
	
	@Column(name = "wm_id")
	private String wmid;
	
	@Column(name = "db_id")
	private String dbid;
	
	@Column(name = "job_no")
	private String jonno;
	
	@Column(name = "r_job_status")
	private String jobststus;
	
	@Column(name ="f_date_time")
	private String datetime;
	
	@Column(name = "pin")
	private String pin;
	
	@Column(name = "commit_date")
	private String enddate;
	
	@Column(name = "task_type")
	private String tasktype;
	
	@Column(name = "task_cat")
	private String task_cat;
	
	@Column(name = "skill_code")
	private String skillcode;
	
	@Column(name = "cow")
	private String cow;
	
	@Column(name = "code_1141")
	private String code;
	
	@Column(name = "postcode")
	private String postcode;
	
	@Column(name = "r_clousure_code")
	private String clousurecode;

	public String getWmid() {
		return wmid;
	}

	public void setWmid(String wmid) {
		this.wmid = wmid;
	}

	public String getDbid() {
		return dbid;
	}

	public void setDbid(String dbid) {
		this.dbid = dbid;
	}

	public String getJonno() {
		return jonno;
	}

	public void setJonno(String jonno) {
		this.jonno = jonno;
	}

	public String getJobststus() {
		return jobststus;
	}

	public void setJobststus(String jobststus) {
		this.jobststus = jobststus;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getTasktype() {
		return tasktype;
	}

	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}

	public String getTask_cat() {
		return task_cat;
	}

	public void setTask_cat(String task_cat) {
		this.task_cat = task_cat;
	}

	public String getSkillcode() {
		return skillcode;
	}

	public void setSkillcode(String skillcode) {
		this.skillcode = skillcode;
	}

	public String getCow() {
		return cow;
	}

	public void setCow(String cow) {
		this.cow = cow;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getClousurecode() {
		return clousurecode;
	}

	public void setClousurecode(String clousurecode) {
		this.clousurecode = clousurecode;
	}

	@Override
	public String toString() {
		return "JobDetails [wmid=" + wmid + ", dbid=" + dbid + ", jonno=" + jonno + ", jobststus=" + jobststus
				+ ", datetime=" + datetime + ", pin=" + pin + ", enddate=" + enddate + ", tasktype=" + tasktype
				+ ", task_cat=" + task_cat + ", skillcode=" + skillcode + ", cow=" + cow + ", code=" + code
				+ ", postcode=" + postcode + ", clousurecode=" + clousurecode + "]";
	}
	
	
	
	
	

}
