package com.socialdemo.socialdemo.dto;

public class SkillMapping implements Comparable<SkillMapping> {
	
	private String skillId;
	
	private String defaultSkill;

	public String getSkillId() {
		return skillId;
	}

	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}

	public String getDefaultSkill() {
		return defaultSkill;
	}

	public void setDefaultSkill(String defaultSkill) {
		this.defaultSkill = defaultSkill;
	}

	@Override
	public int compareTo(SkillMapping arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
