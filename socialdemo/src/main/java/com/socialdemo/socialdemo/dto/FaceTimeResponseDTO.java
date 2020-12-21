package com.socialdemo.socialdemo.dto;

public class FaceTimeResponseDTO {
	
	private String techCode;
	
	private String FaceTimeId;

	public String getTechCode() {
		return techCode;
	}

	public void setTechCode(String techCode) {
		this.techCode = techCode;
	}

	public String getFaceTimeId() {
		return FaceTimeId;
	}

	public void setFaceTimeId(String faceTimeId) {
		FaceTimeId = faceTimeId;
	}

	@Override
	public String toString() {
		return "FaceTimeResponseDTO [techCode=" + techCode + ", FaceTimeId=" + FaceTimeId + "]";
	}

	

}
