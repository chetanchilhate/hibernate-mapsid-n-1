package com.medline.hibernate.dto;

import java.util.List;

public class StudentSubjects {

	private String name;
	private List<AllSubject> subjects;

	public StudentSubjects() {
		// for mapper
	}

	public StudentSubjects(String name, List<AllSubject> subjects) {
		this.name = name;
		this.subjects = subjects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AllSubject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<AllSubject> subjects) {
		this.subjects = subjects;
	}

}
