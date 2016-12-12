package com.joytiger.cihui.model;

import java.io.Serializable;

public class SchoolUserOrder implements Serializable{
	
	private static final long serialVersionUID = 3667071347271936656L;
	private Integer userId;
	private Integer schoolId;
	private String username;
	private String nickname;
	private String avatar;
	private Integer credit;
	private Integer gradeId;
	private Integer classId;
	private Integer raceId;
	private String teacherName;
	public SchoolUserOrder(SchoolRaceUser schoolRaceUser) {
		this.userId =schoolRaceUser.getUser_id();
		this.schoolId = schoolRaceUser.getSchool_id();
		this.credit = schoolRaceUser.getUsercredit();
		this.gradeId = schoolRaceUser.getGrade();
		this.raceId = schoolRaceUser.getRace_id();
	}
	public Integer getUserId() {
		return userId;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public String getUsername() {
		return username;
	}
	public String getNickname() {
		return nickname;
	}
	public String getAvatar() {
		return avatar;
	}
	public Integer getCredit() {
		return credit;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public Integer getClassId() {
		return classId;
	}
	public Integer getRaceId() {
		return raceId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public void setUser(UserInfo userInfo) {
		this.username =userInfo.getUsername();
		this.nickname = userInfo.getNickname();
		this.teacherName = userInfo.getTeacherName();
		this.avatar = userInfo.getAvatar();
		this.classId= userInfo.getClass_id();
		this.schoolId = userInfo.getSchool_id();
	}
	@Override
	public String toString() {
		return "SchoolUserOrder [userId=" + userId + ", schoolId=" + schoolId + ", username=" + username + ", nickname="
				+ nickname + ", avatar=" + avatar + ", credit=" + credit + ", gradeId=" + gradeId + ", classId="
				+ classId + ", raceId=" + raceId + ", teacherName=" + teacherName + "]";
	}
}
