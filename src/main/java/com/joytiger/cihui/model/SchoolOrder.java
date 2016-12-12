package com.joytiger.cihui.model;

public class SchoolOrder {
	
	private Integer schoolId;
	private String schoolName;
	private Integer grade;
	private Integer credit;
	private Integer raceId;
	public Integer getSchoolId() {
		return schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public Integer getGrade() {
		return grade;
	}
	public Integer getCredit() {
		return credit;
	}
	public Integer getRaceId() {
		return raceId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
	@Override
	public String toString() {
		return "SchoolOrder [schoolId=" + schoolId + ", schoolName=" + schoolName + ", grade=" + grade + ", credit="
				+ credit + ", raceId=" + raceId + "]";
	}
	

}
