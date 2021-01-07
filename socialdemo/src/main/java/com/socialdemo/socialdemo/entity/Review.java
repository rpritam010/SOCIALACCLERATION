package com.socialdemo.socialdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "techcode")
	private String techcode;
	
	@Column(name = "question")
	private String question;
	
	@Column(name = "answer")
	private String answer;

	public String getTechcode() {
		return techcode;
	}

	public void setTechcode(String techcode) {
		this.techcode = techcode;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Review [techcode=" + techcode + ", question=" + question + ", answer=" + answer + "]";
	}
	
	

}
