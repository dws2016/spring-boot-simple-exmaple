package com.joytiger.cihui.model;

import java.io.Serializable;

/**
 * Created by dws on 2016/11/6.
 */
public class SchoolRaceUser implements Serializable{


    private Integer race_id;
    private Integer school_id;
    private Integer grade;
    private Integer class_id;
    private Integer user_id;
    private Integer usercredit;

    public Integer getRace_id() {
        return race_id;
    }

    public void setRace_id(Integer race_id) {
        this.race_id = race_id;
    }

    public Integer getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getUsercredit() {
        return usercredit;
    }

    public void setUsercredit(Integer usercredit) {
        this.usercredit = usercredit;
    }

	@Override
	public String toString() {
		return "SchoolRaceUser [race_id=" + race_id + ", school_id=" + school_id + ", grade=" + grade + ", class_id="
				+ class_id + ", user_id=" + user_id + ", usercredit=" + usercredit + "]";
	}
    
    
}
