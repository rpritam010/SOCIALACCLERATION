package com.socialdemo.socialdemo.dto;

import java.util.List;

public class ReviewDTO {

	private String techcode;
	
	private List<Feedback> feedback;

	public String getTechcode() {
		return techcode;
	}

	public void setTechcode(String techcode) {
		this.techcode = techcode;
	}

	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}
	
	
	
}
