package com.medline.hibernate.dto;

import java.util.List;

public class StudentBasicSubjects {

	private String name;
	private List<String> subjects;
	
	public StudentBasicSubjects() {
		// for mapper
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	
}
