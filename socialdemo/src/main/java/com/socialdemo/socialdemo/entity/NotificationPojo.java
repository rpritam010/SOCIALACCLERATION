package com.socialdemo.socialdemo.entity;

import javax.persistence.Entity;

public class NotificationPojo {
	
	private String clickAction;
	
	private String mutableContent;
	
	private String body;
	
	private String title;

	public String getClickAction() {
		return clickAction;
	}

	public void setClickAction(String clickAction) {
		this.clickAction = clickAction;
	}

	public String getMutableContent() {
		return mutableContent;
	}

	public void setMutableContent(String mutableContent) {
		this.mutableContent = mutableContent;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
