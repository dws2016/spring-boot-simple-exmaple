package com.joytiger.cihui.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.joytiger.cihui.model.GradeOrder;
import com.joytiger.cihui.model.UserCredit;
import com.joytiger.cihui.mybatis.mapper.GradeOrderMapper;
import com.joytiger.cihui.mybatis.mapper.SchoolMapper;
import com.joytiger.cihui.mybatis.mapper.UserCreditMapper;
import com.joytiger.cihui.mybatis.mapper.UserInfoMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/11/3.
 */

@RestController
@RequestMapping("/home")
public class BaseController {

	@Autowired
	GradeOrderMapper gradeOrderMapper;

	@Autowired
	SchoolMapper schoolMapper;

	@Autowired
	UserCreditMapper userCreditMapper;
	
	@Autowired
	UserInfoMapper userInfoMapper;

	@RequestMapping(value = "/user")
	@ResponseBody
	public String gradeOrder() {
		int a = 1 / 0;
		GradeOrder gradeOrder = gradeOrderMapper.findGradeOrderByUserId(163);
		return gradeOrder.toString();
	}

	@RequestMapping(value = "/gradeOrder")
	@ResponseBody
	public String gradeOrderList() {
		return gradeOrderMapper.findGradeOrderAll().toString();
	}

	@RequestMapping(value = "/gradeOrderJson")
	@ResponseBody
	public String gradeOrderJson() {
		return JSONObject.toJSON(gradeOrderMapper.findGradeOrderAll()).toString();
	}

	@RequestMapping(value = "/schools")
	@ResponseBody
	public String schoolsJson() {
		return JSONObject.toJSON(schoolMapper.findAllSchool()).toString();
	}

	@RequestMapping(value = "/insertData")
	@ResponseBody
	public String insertData() {
		List<UserCredit> list =Lists.newArrayList();
		UserCredit userCredit =null;
		List<Integer> userIds = userInfoMapper.findAllUserIds();
		for (Integer id : userIds) {
			userCredit = new UserCredit();
			userCredit.setUser_id(id);
			userCredit.setCredit(id);
			userCredit.setRacenum(3);
			userCredit.setSchool_id(144);
			userCredit.setGade(1);
			list.add(userCredit);
		}
		userCreditMapper.insertDatas(list);
			
		return "写入成功";
	}
}
