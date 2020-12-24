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
@Table(name = "wmskillseinsets")
public class Einset implements Serializable{
	private static final long SerialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "einid")
	private int ein;
	
	@Column(name = "vtechcodefk")
	private String techcode;
	
	@Column(name = "vpin")
	private String pin;

	@Column(name = "ouc")
	private String ouc;
	
	@Column(name = "vwmskillcodefk")
	private String skillcode;

	public String getTechcode() {
		return techcode;
	}

	public void setTechcode(String techcode) {
		this.techcode = techcode;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getOuc() {
		return ouc;
	}

	public void setOuc(String ouc) {
		this.ouc = ouc;
	}

	public String getSkillcode() {
		return skillcode;
	}

	public void setSkillcode(String skillcode) {
		this.skillcode = skillcode;
	}

	@Override
	public String toString() {
		return "Einset [techcode=" + techcode + ", pin=" + pin + ", ouc=" + ouc + ", skillcode=" + skillcode + "]";
	}
	
	
	
}
