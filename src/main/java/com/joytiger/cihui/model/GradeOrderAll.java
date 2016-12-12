package com.joytiger.cihui.model;

import java.io.Serializable;

/**
 * 全国年级年级排行榜
 * @author dws
 *
 */
public class GradeOrderAll extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = -3551821314120734051L;
	private Integer userId;
	private String username;
	private String nickname;
	private String avatar;
	private String schoolname;
	private Integer credit;
	private Integer gradeId;
	private Integer order;
	private String teacherName;
	

	public GradeOrderAll(GradeOrder gradeOrder) {
		this.userId = gradeOrder.getUserId();
		this.username= gradeOrder.getUsername();
		this.nickname= gradeOrder.getNickname();
		this.avatar = gradeOrder.getAvatar();
		this.credit = gradeOrder.getCredit();
		this.gradeId = gradeOrder.getGradeId();
		this.teacherName = gradeOrder.getTeacherName();
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public Integer getOrder() {
		return order;
	}


	public void setOrder(Integer order) {
		this.order = order;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getNickname() {
		return nickname;
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


	public String getSchoolname() {
		return schoolname;
	}


	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}


	public Integer getCredit() {
		return credit;
	}


	public void setCredit(Integer credit) {
		this.credit = credit;
	}


	public Integer getGradeId() {
		return gradeId;
	}


	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}


	@Override
	public String toString() {
		return "GradeOrderAll [userId=" + userId + ", username=" + username
				+ ", nickname=" + nickname + ", avatar=" + avatar + ", credit="
				+ credit + ", gradeId=" + gradeId + "]";
	}
}
