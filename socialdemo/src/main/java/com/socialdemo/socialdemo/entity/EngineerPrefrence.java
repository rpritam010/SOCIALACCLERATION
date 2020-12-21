package com.socialdemo.socialdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_prefrence")
public class EngineerPrefrence {
	@Id
    @Column(name = "id", nullable = false, updatable = false)
	private int id;
	
	@Column(name = "tech_code")
	private String techCode;
	
	@Column(name = "skill_code")
	private String skillCode;
	
	@Column(name = "v_group")
	private String vGroup;
	
	@Column(name ="i_prefrence")
	private String iPrefrence;
	
	@Column(name = "active_ind")
	private String active;

	
	
	
	public String getTechCode() {
		return techCode;
	}

	public void setTechCode(String techCode) {
		this.techCode = techCode;
	}

	public String getSkillCode() {
		return skillCode;
	}

	public void setSkillCode(String skillCode) {
		this.skillCode = skillCode;
	}

	public String getvGroup() {
		return vGroup;
	}

	public void setvGroup(String vGroup) {
		this.vGroup = vGroup;
	}

	public String getiPrefrence() {
		return iPrefrence;
	}

	public void setiPrefrence(String iPrefrence) {
		this.iPrefrence = iPrefrence;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "EngineerPrefrence [techCode=" + techCode + ", skillCode=" + skillCode + ", vGroup=" + vGroup
				+ ", iPrefrence=" + iPrefrence + ", active=" + active + "]";
	}
	
	

}
