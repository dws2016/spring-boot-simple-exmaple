package com.joytiger.cihui.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.joytiger.cihui.model.GradeOrderAll;

@Mapper
public interface GradeOrderAllMapper {

	public void find();
	
	@Insert("<script>insert into GradeOrderAll(userId,username,nickname,avatar,credit,gradeId,schoolname,teacherName) values <foreach collection='list' item='item' index='index' separator=','>"
			+ "(#{item.userId},#{item.username},#{item.nickname},#{item.avatar},#{item.credit},#{item.gradeId},#{item.schoolname},#{item.teacherName})</foreach>"
			+ "on DUPLICATE key update credit=values(credit),username=values(username),nickname=values(nickname),avatar=values(avatar),schoolname=values(schoolname),gradeId=values(gradeId),teacherName=values(teacherName)</script>")
	public void insertDatas(List<GradeOrderAll> list);
}
