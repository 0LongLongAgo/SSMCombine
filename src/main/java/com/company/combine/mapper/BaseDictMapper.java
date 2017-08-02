package com.company.combine.mapper;

import com.company.combine.model.BaseDict;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BaseDictMapper {
    @Delete({
        "delete from base_dict",
        "where dict_id = #{dictId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String dictId);

    @Insert({
        "insert into base_dict (dict_id, dict_type_code, ",
        "dict_type_name, dict_item_name, ",
        "dict_item_code, dict_sort, ",
        "dict_enable, dict_memo)",
        "values (#{dictId,jdbcType=VARCHAR}, #{dictTypeCode,jdbcType=VARCHAR}, ",
        "#{dictTypeName,jdbcType=VARCHAR}, #{dictItemName,jdbcType=VARCHAR}, ",
        "#{dictItemCode,jdbcType=VARCHAR}, #{dictSort,jdbcType=INTEGER}, ",
        "#{dictEnable,jdbcType=CHAR}, #{dictMemo,jdbcType=VARCHAR})"
    })
    int insert(BaseDict record);

    @Select({
        "select",
        "dict_id, dict_type_code, dict_type_name, dict_item_name, dict_item_code, dict_sort, ",
        "dict_enable, dict_memo",
        "from base_dict",
        "where dict_id = #{dictId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="dict_id", property="dictId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="dict_type_code", property="dictTypeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_type_name", property="dictTypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_item_name", property="dictItemName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_item_code", property="dictItemCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_sort", property="dictSort", jdbcType=JdbcType.INTEGER),
        @Result(column="dict_enable", property="dictEnable", jdbcType=JdbcType.CHAR),
        @Result(column="dict_memo", property="dictMemo", jdbcType=JdbcType.VARCHAR)
    })
    BaseDict selectByPrimaryKey(String dictId);

    @Select({
        "select",
        "dict_id, dict_type_code, dict_type_name, dict_item_name, dict_item_code, dict_sort, ",
        "dict_enable, dict_memo",
        "from base_dict"
    })
    @Results({
        @Result(column="dict_id", property="dictId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="dict_type_code", property="dictTypeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_type_name", property="dictTypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_item_name", property="dictItemName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_item_code", property="dictItemCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_sort", property="dictSort", jdbcType=JdbcType.INTEGER),
        @Result(column="dict_enable", property="dictEnable", jdbcType=JdbcType.CHAR),
        @Result(column="dict_memo", property="dictMemo", jdbcType=JdbcType.VARCHAR)
    })
    List<BaseDict> selectAll();

    @Update({
        "update base_dict",
        "set dict_type_code = #{dictTypeCode,jdbcType=VARCHAR},",
          "dict_type_name = #{dictTypeName,jdbcType=VARCHAR},",
          "dict_item_name = #{dictItemName,jdbcType=VARCHAR},",
          "dict_item_code = #{dictItemCode,jdbcType=VARCHAR},",
          "dict_sort = #{dictSort,jdbcType=INTEGER},",
          "dict_enable = #{dictEnable,jdbcType=CHAR},",
          "dict_memo = #{dictMemo,jdbcType=VARCHAR}",
        "where dict_id = #{dictId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BaseDict record);
}