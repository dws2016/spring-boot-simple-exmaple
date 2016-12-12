package com.joytiger.cihui.model;

import java.io.Serializable;

public class ClassUserOrder implements Serializable{

	private static final long serialVersionUID = 1545990262095480041L;
	private Integer user_id;
	private Integer school_id;
	private Integer class_id;
	private String nickname;
	private String username;
	private String avatar;
	private String grade;
	private Integer race_id;
	private String teacherName;
	private Integer credit;
	
	public ClassUserOrder(SchoolRaceUser schoolRaceUser) {
		this.user_id = schoolRaceUser.getUser_id();
		this.school_id = schoolRaceUser.getSchool_id();
		this.class_id = schoolRaceUser.getClass_id();
		this.grade = schoolRaceUser.getGrade()+"";
		this.race_id = schoolRaceUser.getRace_id();
		this.credit = schoolRaceUser.getUsercredit();
	}
	public Integer getUser_id() {
		return user_id;
	}
	public Integer getSchool_id() {
		return school_id;
	}
	public Integer getClass_id() {
		return class_id;
	}
	public String getNickname() {
		return nickname;
	}
	public String getUsername() {
		return username;
	}
	public String getAvatar() {
		return avatar;
	}
	public String getGrade() {
		return grade;
	}
	public Integer getRace_id() {
		return race_id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}
	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setRace_id(Integer race_id) {
		this.race_id = race_id;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public void setUser(UserInfo userInfo) {
		if(userInfo!=null){
		this.username =userInfo.getUsername();
		this.nickname = userInfo.getNickname();
		this.avatar = userInfo.getAvatar();
		this.teacherName = userInfo.getTeacherName();
		}else{
			this.username="未找到其人!";
		}
	}
}
