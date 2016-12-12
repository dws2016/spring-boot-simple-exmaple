package com.joytiger.cihui.model;

import java.io.Serializable;

public class ClassOrder implements Serializable{

	private static final long serialVersionUID = -9110724606258741362L;
	private Integer school_id;
	private Integer grade;
	private Integer class_id;
	private Integer race_id;
	private Integer credit;
	public Integer getSchool_id() {
		return school_id;
	}
	public Integer getGrade() {
		return grade;
	}
	public Integer getClass_id() {
		return class_id;
	}
	public Integer getRace_id() {
		return race_id;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}
	public void setRace_id(Integer race_id) {
		this.race_id = race_id;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	
	
}
