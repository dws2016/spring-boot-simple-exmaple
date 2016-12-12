package com.joytiger.cihui.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.joytiger.cihui.model.ClassUserOrder;

@Mapper
public interface ClassUserOrderMapper {
	
	@Insert("<script>insert into ClassUserOrder(user_id,school_id,class_id,nickname,username,avatar,grade,race_id,teacherName,credit)values"
			+ "<foreach collection='list' item='item' index='index'  separator=',' >"
			+ "(#{item.user_id},#{item.school_id},#{item.class_id},#{item.nickname},#{item.username},#{item.avatar},#{item.grade},#{item.race_id},#{item.teacherName},#{item.credit})</foreach>"
			+ "on duplicate key update school_id=values(school_id),class_id=values(class_id),nickname=values(nickname),avatar=values(avatar),grade=values(grade),teacherName=values(teacherName),credit=values(credit)"
			+ "</script>")
	void insertDatas(List<ClassUserOrder> list);
	
	@Delete("delete from ClassUserOrder where raceId=#{raceId}")
	void deleteByRaceId(@Param("raceId")Integer raceId);
}
