package com.joytiger.cihui.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.joytiger.cihui.model.School;

@Mapper
public interface SchoolMapper {
	@Select("select * from school")
	List<School> findAllSchool();
	
	@Select("select school_id from school")
	List<Integer> findAllSchoolIds();

	@Select("select * from school where school_id =#{schoolId}")
	School findSchoolById(@Param("schoolId")Integer schoolId);
}
