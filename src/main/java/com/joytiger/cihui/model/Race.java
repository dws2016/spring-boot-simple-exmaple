package com.joytiger.cihui.model;

import java.io.Serializable;

/**
 * Created by dws on 2016/11/6.
 */
public class Race implements Serializable {

private Integer race_id;
    private String race_name;
    private Long starttime;
    private Long endtime;
    private String desc;
    private String gradetype;
    private String city;
    private String province;
    private String district;
    private String raceDetailInfoUrl;
    private Integer school_id;


    public Integer getRace_id() {
        return race_id;
    }

    public void setRace_id(Integer race_id) {
        this.race_id = race_id;
    }

    public String getRace_name() {
        return race_name;
    }

    public void setRace_name(String race_name) {
        this.race_name = race_name;
    }

    public Long getStarttime() {
        return starttime;
    }

    public void setStarttime(Long starttime) {
        this.starttime = starttime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getGradetype() {
        return gradetype;
    }

    public void setGradetype(String gradetype) {
        this.gradetype = gradetype;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRaceDetailInfoUrl() {
        return raceDetailInfoUrl;
    }

    public void setRaceDetailInfoUrl(String raceDetailInfoUrl) {
        this.raceDetailInfoUrl = raceDetailInfoUrl;
    }

    public Integer getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }

    public Long getEndtime() {

        return endtime;
    }

    public void setEndtime(Long endtime) {
        this.endtime = endtime;
    }
}
