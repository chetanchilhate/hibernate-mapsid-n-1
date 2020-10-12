package com.medline.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_basic_subject")
public class BasicSubject {

	private Long id;
	private String name;
	private Student student;
	private AlternateSubject alternateSubject;

	public BasicSubject() {
		// for hibernate
	}

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	public AlternateSubject getAlternateSubject() {
		return alternateSubject;
	}

	public void setAlternateSubject(AlternateSubject alternateSubject) {
		this.alternateSubject = alternateSubject;
	}

}
