package com.joytiger.cihui.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.joytiger.cihui.model.ClassOrder;

@Mapper
public interface ClassOrderMapper {

	@Insert("<script>insert into ClassOrder(school_id,grade,class_id"
			+ ",race_id,credit)values<foreach collection='list' item='item' index='index'  separator=',' >"
			+ "(#{item.school_id},#{item.grade},#{item.class_id},#{item.race_id},#{item.credit})</foreach>"
			+ "on duplicate key update school_id=values(school_id),grade=values(grade),class_id=values(class_id),"
			+ "credit=values(credit)" + "</script>")
	void insertDatas(List<ClassOrder> list);

}
