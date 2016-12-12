package com.joytiger.cihui.mybatis.mapper;

import com.joytiger.cihui.model.GradeOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GradeOrderMapper {
	GradeOrder findGradeOrder();

	@Select("select * from GradeOrder where userId=#{userId}")
	GradeOrder findGradeOrderByUserId(@Param("userId") Integer userId);

	@Select("select * from GradeOrder")
	List<GradeOrder> findGradeOrderAll();

	@Insert("<script>insert into GradeOrder(userId,username,nickname,"
			+ "avatar,credit,schoolId,gradeId,classname,teacherName) values "
			+ "<foreach collection='list' item='item' index='index'  separator=',' >  "
			+ "(#{item.userId},#{item.username},#{item.nickname},#{item.avatar},#{item.credit},#{item.schoolId},"
			+ "#{item.gradeId},#{item.classname},#{item.teacherName})</foreach> "
			+ "on DUPLICATE key update credit=values(credit),schoolId=values(schoolId),"
			+ "classname=values(classname),nickname=values(nickname),avatar=values(avatar),gradeId=values(gradeId)</script>")
	void insertDatas(List<GradeOrder> list);

	@Delete("delete from gradeOrder")
	void removeAll();

	// insert into
	// ordersdish(id,ordersId,dishId)
	// values
	// <foreach collection="list" item="item" index="index"
	// separator=",">
	// (#{item.id,jdbcType=VARCHAR},#{item.orderId,jdbcType=BIGINT},#{item.dishId,jdbcType=INTEGER})
	// </foreach>
}
