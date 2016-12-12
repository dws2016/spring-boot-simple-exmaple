package com.joytiger.cihui.model;
// default package



/**
 * UserCredit entity. @author MyEclipse Persistence Tools
 */

/**
 * @author Administrator
 *
 */
public class UserCredit  implements java.io.Serializable {

	private static final long serialVersionUID = -5785010397396427599L;
	// Fields    

     private Integer id;
     private Integer user_id;
     private Integer gade;
     private Integer school_id;
     private Integer credit;

     private Integer racenum;

    /** default constructor */
    public UserCredit() {
    }


	public Integer getId() {
		return id;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public Integer getGade() {
		return gade;
	}


	public Integer getSchool_id() {
		return school_id;
	}


	public Integer getCredit() {
		return credit;
	}


	public Integer getRacenum() {
		return racenum;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public void setGade(Integer gade) {
		this.gade = gade;
	}


	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}


	public void setCredit(Integer credit) {
		this.credit = credit;
	}


	public void setRacenum(Integer racenum) {
		this.racenum = racenum;
	}

	
	
    
    
}