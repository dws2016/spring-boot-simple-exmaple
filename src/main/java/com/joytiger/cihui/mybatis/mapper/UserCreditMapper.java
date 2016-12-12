package com.joytiger.cihui.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.joytiger.cihui.model.UserCredit;

@Mapper
public interface UserCreditMapper {

	@Select("select * from user_credit where school_id=#{schoolId} and gade=#{grade}")
	List<UserCredit> findUserCreditByClass(@Param("schoolId")Integer schoolId,@Param("grade")Integer grade);

	@Select("select * from user_credit")
	List<UserCredit> findUserCreditAll();

//	collection='list' item='item' index='index'  separator=','
	@Insert("<script>insert into user_credit(user_id,gade,school_id,credit,racenum) values <foreach collection='list' item='item' index='index'  separator=','>("
			+ "#{item.user_id},#{item.gade},#{item.school_id},#{item.credit},#{item.racenum})"
			+ "</foreach>"
			+ "on duplicate key update gade=values(gade),school_id=values(school_id),credit=values(credit),racenum=values(racenum)</script>")
	void insertDatas(List<UserCredit> list);
}
//private Integer id;
//private Integer user_id;
//private Integer gade;
//private Integer school_id;
//private Integer credit;
//
//private Integer racenum;