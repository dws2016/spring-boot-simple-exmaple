package com.joytiger.cihui.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.joytiger.cihui.model.SchoolRaceUser;

/**
 * Created by dws on 2016/11/6.
 */
@Mapper
public interface SchoolRaceUserMapper {

	@Select("select * from school_race_user where race_id=#{raceId}")
	List<SchoolRaceUser> findSchoolRaceUser(Integer raceId);
}
