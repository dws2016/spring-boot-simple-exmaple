package com.joytiger.cihui.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.joytiger.cihui.mybatis.mapper.*;
import com.joytiger.cihui.util.NumFarmatUitls;
import com.joytiger.cihui.util.TimeUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.druid.support.logging.Log;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.joytiger.cihui.model.*;

@Component
public class MyJob {
	private static Logger logger = LoggerFactory.getLogger(MyJob.class);
	@Autowired
	GradeOrderMapper gradeOrderMapper;
	@Autowired
	SchoolMapper schoolMapper;
	@Autowired
	UserCreditMapper userCreditMapper;
	@Autowired
	UserInfoMapper userInfoMapper;
	@Autowired
	GradeOrderAllMapper gradeOrderAllMapper;
	@Autowired
	RaceMapper raceMapper;
	@Autowired
	SchoolRaceUserMapper schoolRaceUserMapper;
	@Autowired
	SchoolUserOrderMapper schoolUserOrderMapper;
	@Autowired
	ClassUserOrderMapper classUserOrderMapper;
	@Autowired
	ClassOrderMapper classOrderMapper;
	@Autowired
	SchoolOrderMapper schoolOrderMapper;

	/**
	 * 年纪排行榜
	 */
	@Scheduled(fixedRate = 60000) // 1min
	public void gradeOder() {
		logger.info("年级榜 开始");

		List<GradeOrder> list = Lists.newArrayList();
		List<GradeOrderAll> list2 = Lists.newArrayList();
		GradeOrder gradeOrder = null;
		GradeOrderAll gradeOrderAll = null;
		// 获取所有的得分记录
		List<UserCredit> userCredits = userCreditMapper.findUserCreditAll();
		for (UserCredit userCredit : userCredits) {
			Integer userId = userCredit.getUser_id();
			UserInfo user = userInfoMapper.findUser(userId);
			Integer schoolId = user.getSchool_id();
			if (schoolId != null && 0 != schoolId) {
				gradeOrder = new GradeOrder(user);
				gradeOrder.setCredit(userCredit.getCredit());
				list.add(gradeOrder);
				gradeOrderAll = new GradeOrderAll(gradeOrder);
				School school = schoolMapper.findSchoolById(schoolId);
				if (school != null) {
					gradeOrderAll.setSchoolname(school.getSchool_name());
				} else {
					gradeOrderAll.setSchoolname("该学校不存在!");
				}
				list2.add(gradeOrderAll);
			}
		}
		if (list != null && list.size() > 0) {
			gradeOrderMapper.insertDatas(list);
		}
		logger.info("校内年级榜完成");
		Ordering<GradeOrderAll> order = new Ordering<GradeOrderAll>() {
			@Override
			public int compare(GradeOrderAll left, GradeOrderAll right) {
				return right.getCredit() - left.getCredit();
			}
		};
		list2 = order.sortedCopy(list2);
		if (list2 != null && list2.size() > 500) {
			list2 = list2.subList(0, 500);
		}

		if (list2 != null && list2.size() > 0) {
			gradeOrderAllMapper.insertDatas(list2);
		}
		logger.info("全国年级榜完成");
	}

	/**
	 * 校内竞赛排行
	 */
	@Scheduled(fixedRate = 5 * 60 * 1000) // 5min
	public void schoolRaceOrder() {
		// 校内赛
		// 先获取所有校内赛\
		logger.info("开始跟新校内竞赛");
		List<Race> races = raceMapper.findSchoolRaces();
		// List<SchoolUserOrder> list =Lists.newArrayList();
		List<ClassUserOrder> list2 = Lists.newArrayList();
		List<ClassOrder> list3 = Lists.newArrayList();
		ClassUserOrder classUserOrder = null;
		ClassOrder classOrder = null;

		if (races != null) {
			for (Race race : races) {
				Long nowTime = TimeUtils.getNowTime();
				Long starttime = race.getStarttime();
				Long endtime = race.getEndtime();
				if (nowTime > starttime && nowTime < endtime) {
					logger.info("校内竞赛:"+race.getRace_name()+"正在进行!");
					Integer schoolId = race.getSchool_id();
					HashMap<Object, Object> classIds = Maps.newHashMap();
					Integer raceId = race.getRace_id();
					// 获取该竞赛下所有人的积分
					List<SchoolRaceUser> schoolRaceUsers = schoolRaceUserMapper.findSchoolRaceUser(raceId);
					logger.info("查询到的积分为:"+schoolRaceUsers);
					if (schoolRaceUsers != null && schoolRaceUsers.size() > 0) {
						// schoolUserOrderMapper.deleteByRaceId(raceId);
						for (SchoolRaceUser schoolRaceUser : schoolRaceUsers) {
							Integer userId = schoolRaceUser.getUser_id();
							UserInfo userInfo = userInfoMapper.findUser(userId);
							if (userInfo == null) {
								continue;
							}
							classUserOrder = new ClassUserOrder(schoolRaceUser);
							classUserOrder.setUser(userInfo);
							list2.add(classUserOrder);
							Integer classId = userInfo.getClass_id();
							if (classIds.containsKey(classId)) {
								classIds.put(classId, NumFarmatUitls.objToInteger(classIds.get(classId))
										+ schoolRaceUser.getUsercredit());
							} else {
								classIds.put(classId, schoolRaceUser.getUsercredit());
							}
						}
						if (!classIds.isEmpty()) {
							Set<Object> set = classIds.keySet();

							ArrayList<Object> arrayList = new ArrayList<>(set);
							logger.info(arrayList.toString());
							for (Object object : arrayList) {
								classOrder = new ClassOrder();
								classOrder.setSchool_id(schoolId);
								classOrder.setClass_id(NumFarmatUitls.objToInteger(object));
								classOrder.setCredit(NumFarmatUitls.objToInteger(classIds.get(object)));
								classOrder.setGrade(NumFarmatUitls.objToInteger(race.getGradetype()));
								classOrder.setRace_id(raceId);
								list3.add(classOrder);
							}
						}
						// 更新数据
						logger.info("需要更新的数据1:"+list2);
						logger.info("需要更新的数据2:"+list3);
						
						if (list2.size() > 0)
							classUserOrderMapper.insertDatas(list2);
						if (list3.size() > 0)
							classOrderMapper.insertDatas(list3);
					}
					logger.info("校内竞赛完成!");
				} else {
					logger.error("校内比赛" + race.getRace_name() + "已经过时了");
				}
			}
		}
	}

	/**
	 * 区域赛排行
	 */
	@Scheduled(fixedRate = 5 * 60 * 1000) // 5min
	public void areaRaceOrder() {
		// 区域赛
		// 先获取所有区域赛
		logger.info("开始更新区域竞赛");
		List<Race> races = raceMapper.findAreaRaces();
		List<SchoolOrder> list1 = Lists.newArrayList();
		List<SchoolUserOrder> list2 = Lists.newArrayList();
		SchoolOrder schoolOrder = null;
		SchoolUserOrder schoolUserOrder = null;

		if (races != null) {
			for (Race race : races) {
				Long nowTime = TimeUtils.getNowTime();
				Long starttime = race.getStarttime();
				Long endtime = race.getEndtime();
				if (nowTime > starttime && nowTime < endtime) {
					logger.info("区域竞赛:"+race.getRace_name()+"正在进行!");
					Integer raceId = race.getRace_id();
					HashMap<Object, Object> schoolIds = Maps.newHashMap();
					// 获取所有参赛人员
					List<SchoolRaceUser> schoolRaceUsers = schoolRaceUserMapper.findSchoolRaceUser(raceId);
					for (SchoolRaceUser schoolRaceUser : schoolRaceUsers) {
						Integer userId = schoolRaceUser.getUser_id();
						UserInfo userInfo = userInfoMapper.findUser(userId);
						schoolUserOrder = new SchoolUserOrder(schoolRaceUser);
						schoolUserOrder.setUser(userInfo);
						list2.add(schoolUserOrder);
						Integer classId = userInfo.getClass_id();
						Integer schoolId = userInfo.getSchool_id();
						School school = schoolMapper.findSchoolById(schoolId);

						if (schoolIds.containsKey(schoolId)) {
							schoolIds.put(schoolId, NumFarmatUitls.objToInteger(schoolIds.get(schoolId))
									+ schoolRaceUser.getUsercredit());
						} else {
							schoolIds.put(schoolId, schoolRaceUser.getUsercredit());
						}

						if (!schoolIds.isEmpty()) {
							Set<Object> set = schoolIds.keySet();
							for (Object object : set) {
								schoolOrder = new SchoolOrder();
								schoolOrder.setSchoolId(NumFarmatUitls.objToInteger(object));
								schoolOrder.setCredit(NumFarmatUitls.objToInteger(schoolIds.get(object)));
								schoolOrder.setGrade(NumFarmatUitls.objToInteger(race.getGradetype()));
								schoolOrder.setRaceId(raceId);
								if (school != null) {
									schoolOrder.setSchoolName(school.getSchool_name());
								} else {
									schoolOrder.setSchoolName("该学校不存在!");
								}
								list1.add(schoolOrder);
							}
						}
					}		
					logger.info("区域学校列表"+list1);
					logger.info("区域学生列表"+list2);
					if (list1.size() > 0){
						schoolOrderMapper.insertDatas(list1);}
					if (list2.size() > 0){
						schoolUserOrderMapper.insertDatas(list2);
					}
					//
					logger.info("区域比赛更新完成");
				} else {
					logger.error("区域比赛" + race.getRace_name() + "已经过时了");
				}
			}
		}
	}
}
