package com.medline.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_alternate_subject")
public class AlternateSubject {

	private Long id;
	private String name;
	private BasicSubject basicSubject;

	public AlternateSubject() {
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
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "id")
	public BasicSubject getBasicSubject() {
		return basicSubject;
	}

	public void setBasicSubject(BasicSubject basicSubject) {
		this.basicSubject = basicSubject;
	}
	
}
