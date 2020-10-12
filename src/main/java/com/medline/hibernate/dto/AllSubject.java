package com.medline.hibernate.dto;

public class AllSubject {

	private String basic;
	private String alternate;

	public AllSubject() {
		// dto
	}

	public AllSubject(String basic, String alternate) {
		this.basic = basic;
		this.alternate = alternate;
	}

	public String getBasic() {
		return basic;
	}

	public void setBasic(String basic) {
		this.basic = basic;
	}

	public String getAlternate() {
		return alternate;
	}

	public void setAlternate(String alternate) {
		this.alternate = alternate;
	}

}
