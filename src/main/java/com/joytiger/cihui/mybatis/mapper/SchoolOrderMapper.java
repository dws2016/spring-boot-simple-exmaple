package com.joytiger.cihui.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.joytiger.cihui.model.SchoolOrder;

@Mapper
public interface SchoolOrderMapper {

	@Insert("<script>insert into SchoolOrder(schoolId,schoolName,grade,credit,raceId)"
			+ "values<foreach collection='list' item='item' index='index'  separator=',' >"
			+ "(#{item.schoolId},#{item.schoolName},#{item.grade},#{item.credit}"
			+ ",#{item.raceId})</foreach> on duplicate key update credit=values(credit)"
			+ "</script>")
	void insertDatas(List<SchoolOrder> list);

}
