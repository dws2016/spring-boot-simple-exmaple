package com.joytiger.cihui.model;

/**
 * School entity. @author MyEclipse Persistence Tools
 */

public class School implements java.io.Serializable {
	private static final long serialVersionUID = -5413897834790734803L;
	// Fields

	private Integer school_id;
	private Integer quizii_school_id;
	private String school_name;
	private String province;
	private String city;
	private String district;
	private Integer isdisable;//是否禁用 0未禁用 1表示禁用
	private String isdisable_desc;//操作说明
	private String username;//学校账号
	private String password;//学校密码
	private String gradetype;//学段 可以是多个 1,2,3   1为小学 2为初中 3为高中
	private String phone;//手机号
	private String school_code;//学校码 6位，不能重复
	private String server_code;//学校标示码

	public School() {
	}

	public Integer getSchool_id() {
		return school_id;
	}

	public Integer getQuizii_school_id() {
		return quizii_school_id;
	}

	public String getSchool_name() {
		return school_name;
	}

	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public String getDistrict() {
		return district;
	}

	public Integer getIsdisable() {
		return isdisable;
	}

	public String getIsdisable_desc() {
		return isdisable_desc;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getGradetype() {
		return gradetype;
	}

	public String getPhone() {
		return phone;
	}

	public String getSchool_code() {
		return school_code;
	}

	public String getServer_code() {
		return server_code;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

	public void setQuizii_school_id(Integer quizii_school_id) {
		this.quizii_school_id = quizii_school_id;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setIsdisable(Integer isdisable) {
		this.isdisable = isdisable;
	}

	public void setIsdisable_desc(String isdisable_desc) {
		this.isdisable_desc = isdisable_desc;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setGradetype(String gradetype) {
		this.gradetype = gradetype;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setSchool_code(String school_code) {
		this.school_code = school_code;
	}

	public void setServer_code(String server_code) {
		this.server_code = server_code;
	}

	
	
}

