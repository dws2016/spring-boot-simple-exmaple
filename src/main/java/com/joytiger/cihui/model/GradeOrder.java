package com.joytiger.cihui.model;

import java.io.Serializable;

import com.google.common.base.Strings;

public class GradeOrder extends BaseEntity  implements Serializable{
	
	
	private static final long serialVersionUID = 6306136468842256430L;
	private Integer order;
	private Integer userId;
	private Integer credit;
	private Integer schoolId;
	private String nickname;
	private String avatar;
	private Integer gradeId;
	private String username;
	private String classname;
	private String teacherName;
	
	private GradeOrder() {
		super();
	}
	public GradeOrder(UserInfo user) {
		this.userId = user.getUser_id();
		this.schoolId = user.getSchool_id();
		this.nickname = user.getNickname();
		this.avatar =user.getAvatar();
		this.gradeId = user.getGrade();
		this.username = user.getUsername();
		if(Strings.isNullOrEmpty(this.nickname)){
			this.nickname = user.getUsername();
		}
		this.classname = user.getClass_id()+"班";
		this.teacherName = user.getTeacherName();
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
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
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	@Override
	public String toString() {
		return "GradeOrder{" +
				"order=" + order +
				", userId=" + userId +
				", credit=" + credit +
				", schoolId=" + schoolId +
				", nickname='" + nickname + '\'' +
				", avatar='" + avatar + '\'' +
				", gradeId=" + gradeId +
				", username='" + username + '\'' +
				", classname='" + classname + '\'' +
				", teacherName='" + teacherName + '\'' +
				'}';
	}
}
