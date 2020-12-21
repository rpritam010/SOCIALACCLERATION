package com.socialdemo.socialdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_profile")
public class Profile {
	
	
	@Id
    @Column(name = "techcode", nullable = false, updatable = false)
	private String techcode;
	
	@Column(name = "name")
	private String Name;
	
	@Column(name = "face_time_id")
	private String FaceTimeId;
	
	@Column(name = "device_token")
	private String DeviceToken;
	
	@Column(name = "status")
	private String Status;

	public String getTechcode() {
		return techcode;
	}

	public void setTechcode(String techcode) {
		this.techcode = techcode;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getFaceTimeId() {
		return FaceTimeId;
	}

	public void setFaceTimeId(String faceTimeId) {
		FaceTimeId = faceTimeId;
	}

	public String getDeviceToken() {
		return DeviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		DeviceToken = deviceToken;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "Profile [techcode=" + techcode + ", Name=" + Name + ", FaceTimeId=" + FaceTimeId + ", DeviceToken="
				+ DeviceToken + ", Status=" + Status + "]";
	}
	
	
	

	

}
