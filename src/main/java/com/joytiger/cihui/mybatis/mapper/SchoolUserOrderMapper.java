package com.joytiger.cihui.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.joytiger.cihui.model.SchoolUserOrder;

@Mapper
public interface SchoolUserOrderMapper {
	
	@Select("select * from SchoolUserOrder where race_Id=#{raceId}")
	List<SchoolUserOrder> findByRaceId(@Param("raceId")Integer raceId);
	
	@Delete("delete from SchoolUserOrder where race_Id=#{raceId}")
	void deleteByRaceId(@Param("raceId")Integer raceId);
	
	@Insert("<script>insert into SchoolUserOrder(userId,schoolId,username,nickname,avatar,credit,gradeId,classId,raceId,teacherName)"
			+ "values<foreach collection='list' item='item' index='index'  separator=',' >"
			+ "(#{item.userId},#{item.schoolId},#{item.username},#{item.nickname},#{item.avatar},#{item.credit},#{item.gradeId},"
			+ "#{item.classId},#{item.raceId},#{item.teacherName}"
			+ ")</foreach> on duplicate key update credit=values(credit),schoolId=values(schoolId),nickname=values(nickname),avatar=values(avatar),gradeId=values(gradeId),"
			+ "classId=values(classId),teacherName=values(teacherName)</script>")
	void insertDatas(List<SchoolUserOrder> list);
}
