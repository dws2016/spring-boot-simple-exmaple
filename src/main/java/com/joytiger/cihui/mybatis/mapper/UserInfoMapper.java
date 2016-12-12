package com.joytiger.cihui.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.joytiger.cihui.model.UserInfo;

@Mapper
public interface UserInfoMapper {

	@Select("select * from user_info where user_id=#{userId}")
	UserInfo findUser(@Param("userId")Integer userId);
	
	@Select("select * from user_info where school_id=#{schoolId}")
	List<UserInfo> findUsersBySchoolId(@Param("schoolId")Integer schoolId);
	
	@Select("select *　from user_info where school_id=#{schoolId} and gade=#{grade}")
	List<UserInfo> findUsersByGrade(@Param("schoolId")Integer schoolId,@Param("grade")Integer grade);
	
	@Select("select * from user_info where school_id=#{schoolId} and gade=#{grade} and class_id=#{classId}")
	List<UserInfo> findUsersByClass(@Param("schoolId")Integer schoolId,@Param("grade")Integer grade,@Param("classId")Integer classId);

	@Select("select user_id from user_info")
	List<Integer> findAllUserIds();
	
}
