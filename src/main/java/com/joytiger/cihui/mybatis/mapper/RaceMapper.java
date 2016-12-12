package com.joytiger.cihui.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.joytiger.cihui.model.Race;

import java.util.List;

/**
 * Created by dws on 2016/11/6.
 */
@Mapper
public interface RaceMapper {
	/**
	 * 查询校内竞赛id
	 * @return
	 */
    @Select("select race_id from race where school_id is not null and school_id!=0")
    List<Integer> findSchoolRaceIds();
    
    /**
     * 查询校内竞赛
     * @return
     */
    @Select("select * from race where school_id is not null and school_id!=0")
    List<Race> findSchoolRaces();

    /**
     * 查询区域竞赛
     * @return
     */
    @Select("select * from race where school_id is null or school_id=0")
	List<Race> findAreaRaces();
}
