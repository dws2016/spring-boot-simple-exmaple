package com.joytiger.cihui.model;

// default package

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer user_id;
	

	private Integer quizii_user_id;

	private String nickname;

	private String avatar;

	private String phone;
	
	private String username;

	private String password;

	private Integer school_id;

	private Integer grade;

	private Integer class_id;
	
	private String teacherName;

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public Integer getQuizii_user_id() {
		return quizii_user_id;
	}

	public String getNickname() {
		return nickname;
	}


	public String getPhone() {
		return phone;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}


	public Integer getClass_id() {
		return class_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public void setQuizii_user_id(Integer quizii_user_id) {
		this.quizii_user_id = quizii_user_id;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}

	public Integer getSchool_id() {
		return school_id;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public UserInfo() {
		super();
	}

	@Override
	public String toString() {
		return "UserInfo [user_id=" + user_id + ", quizii_user_id=" + quizii_user_id + ", nickname=" + nickname
				+ ", avatar=" + avatar + ", phone=" + phone + ", username=" + username + ", password=" + password
				+ ", school_id=" + school_id + ", grade=" + grade + ", class_id=" + class_id + ", teacherName="
				+ teacherName + "]";
	}
	
	
	
	
	
}