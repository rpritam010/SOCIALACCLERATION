package com.socialdemo.socialdemo.dto;

import javax.persistence.Column;

public class ReceiverNotificationDTO {

	private String groupid;

	private String recetechcode;

	private String status;

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getRecetechcode() {
		return recetechcode;
	}

	public void setRecetechcode(String recetechcode) {
		this.recetechcode = recetechcode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
