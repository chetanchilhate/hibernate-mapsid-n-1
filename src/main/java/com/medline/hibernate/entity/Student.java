package com.medline.hibernate.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_student")
public class Student {

	private Long id;
	private String name;
	private Set<BasicSubject> basicSubject;

	public Student() {
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

	@OneToMany(mappedBy = "student",  fetch = FetchType.EAGER)
	public Set<BasicSubject> getBasicSubject() {
		return basicSubject;
	}

	public void setBasicSubject(Set<BasicSubject> basicSubject) {
		this.basicSubject = basicSubject;
	}

}
