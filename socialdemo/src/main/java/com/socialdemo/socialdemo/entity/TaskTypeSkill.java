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
@Table(name = "task_type_skill")
public class TaskTypeSkill implements Serializable{
	
	private static final long SerialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Tts_id")
	private int id;
	
	@Column(name = "wm_id")
	private String wmid;
	
	@Column(name = "task_type")
	private String tasktype;
	
	@Column(name = "skill_code")
	private String skillcode;
	
	@Column(name = "task_skill_id_no")
	private String taskskillidno;
	
	@Column(name = "estimated_duration")
	private String estimatedduration;
	
	@Column(name = "no_techs")
	private String techs;
	
	@Column(name = "last_updated")
	private String lastupdated;

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

	public String getSkillcode() {
		return skillcode;
	}

	public void setSkillcode(String skillcode) {
		this.skillcode = skillcode;
	}

	public String getTaskskillidno() {
		return taskskillidno;
	}

	public void setTaskskillidno(String taskskillidno) {
		this.taskskillidno = taskskillidno;
	}

	public String getEstimatedduration() {
		return estimatedduration;
	}

	public void setEstimatedduration(String estimatedduration) {
		this.estimatedduration = estimatedduration;
	}

	public String getTechs() {
		return techs;
	}

	public void setTechs(String techs) {
		this.techs = techs;
	}

	public String getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(String lastupdated) {
		this.lastupdated = lastupdated;
	}

	@Override
	public String toString() {
		return "TaskTypeSkill [wmid=" + wmid + ", tasktype=" + tasktype + ", skillcode=" + skillcode
				+ ", taskskillidno=" + taskskillidno + ", estimatedduration=" + estimatedduration + ", techs=" + techs
				+ ", lastupdated=" + lastupdated + "]";
	}
	
	
	

}
