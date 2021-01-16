package com.socialdemo.socialdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="receiver_notification")
public class ReceiverNotification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "groupid")
	private String groupid;
	
	@Column(name = "reqtechcode")
	private String reqtechcode;
	
	@Column(name = "recetechcode")
	private String recetechcode;
	
	@Column(name = "status")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getReqtechcode() {
		return reqtechcode;
	}

	public void setReqtechcode(String reqtechcode) {
		this.reqtechcode = reqtechcode;
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

	@Override
	public String toString() {
		return "ReceiverNotification [id=" + id + ", groupid=" + groupid + ", reqtechcode=" + reqtechcode
				+ ", recetechcode=" + recetechcode + ", status=" + status + "]";
	}
	
	

}
