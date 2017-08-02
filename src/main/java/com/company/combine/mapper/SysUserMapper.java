package com.company.combine.mapper;

import com.company.combine.model.SysUser;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper {
    @Delete({
        "delete from sys_user",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userId);

    @Insert({
        "insert into sys_user (user_id, user_code, ",
        "user_name, user_password, ",
        "user_state)",
        "values (#{userId,jdbcType=BIGINT}, #{userCode,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=VARCHAR}, #{userPassword,jdbcType=VARCHAR}, ",
        "#{userState,jdbcType=CHAR})"
    })
    int insert(SysUser record);

    @Select({
        "select",
        "user_id, user_code, user_name, user_password, user_state",
        "from sys_user",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_password", property="userPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_state", property="userState", jdbcType=JdbcType.CHAR)
    })
    SysUser selectByPrimaryKey(Long userId);

    @Select({
        "select",
        "user_id, user_code, user_name, user_password, user_state",
        "from sys_user"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_password", property="userPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_state", property="userState", jdbcType=JdbcType.CHAR)
    })
    List<SysUser> selectAll();

    @Update({
        "update sys_user",
        "set user_code = #{userCode,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "user_password = #{userPassword,jdbcType=VARCHAR},",
          "user_state = #{userState,jdbcType=CHAR}",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysUser record);
}