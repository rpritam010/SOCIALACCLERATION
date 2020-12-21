package com.socialdemo.socialdemo.dto;

public class StatusResponseDTO {
	
	private String techCode;
	
	private String Status;

	public String getTechCode() {
		return techCode;
	}

	public void setTechCode(String techCode) {
		this.techCode = techCode;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "StatusResponseDTO [techCode=" + techCode + ", Status=" + Status + "]";
	}
	
	

}
