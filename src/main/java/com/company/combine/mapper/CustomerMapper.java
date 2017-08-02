package com.company.combine.mapper;

import com.company.combine.model.Customer;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface CustomerMapper {
    @Delete({
        "delete from customer",
        "where cust_id = #{custId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long custId);

    @Insert({
        "insert into customer (cust_id, cust_name, ",
        "cust_user_id, cust_create_id, ",
        "cust_source, cust_industry, ",
        "cust_level, cust_linkman, ",
        "cust_phone, cust_mobile, ",
        "cust_zipcode, cust_address, ",
        "cust_createtime)",
        "values (#{custId,jdbcType=BIGINT}, #{custName,jdbcType=VARCHAR}, ",
        "#{custUserId,jdbcType=BIGINT}, #{custCreateId,jdbcType=BIGINT}, ",
        "#{custSource,jdbcType=VARCHAR}, #{custIndustry,jdbcType=VARCHAR}, ",
        "#{custLevel,jdbcType=VARCHAR}, #{custLinkman,jdbcType=VARCHAR}, ",
        "#{custPhone,jdbcType=VARCHAR}, #{custMobile,jdbcType=VARCHAR}, ",
        "#{custZipcode,jdbcType=VARCHAR}, #{custAddress,jdbcType=VARCHAR}, ",
        "#{custCreatetime,jdbcType=TIMESTAMP})"
    })
    int insert(Customer record);

    @Select({
        "select",
        "cust_id, cust_name, cust_user_id, cust_create_id, cust_source, cust_industry, ",
        "cust_level, cust_linkman, cust_phone, cust_mobile, cust_zipcode, cust_address, ",
        "cust_createtime",
        "from customer",
        "where cust_id = #{custId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="cust_id", property="custId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="cust_name", property="custName", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_user_id", property="custUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="cust_create_id", property="custCreateId", jdbcType=JdbcType.BIGINT),
        @Result(column="cust_source", property="custSource", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_industry", property="custIndustry", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_level", property="custLevel", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_linkman", property="custLinkman", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_phone", property="custPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_mobile", property="custMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_zipcode", property="custZipcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_address", property="custAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_createtime", property="custCreatetime", jdbcType=JdbcType.TIMESTAMP)
    })
    Customer selectByPrimaryKey(Long custId);

    @Select({
        "select",
        "cust_id, cust_name, cust_user_id, cust_create_id, cust_source, cust_industry, ",
        "cust_level, cust_linkman, cust_phone, cust_mobile, cust_zipcode, cust_address, ",
        "cust_createtime",
        "from customer"
    })
    @Results({
        @Result(column="cust_id", property="custId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="cust_name", property="custName", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_user_id", property="custUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="cust_create_id", property="custCreateId", jdbcType=JdbcType.BIGINT),
        @Result(column="cust_source", property="custSource", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_industry", property="custIndustry", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_level", property="custLevel", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_linkman", property="custLinkman", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_phone", property="custPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_mobile", property="custMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_zipcode", property="custZipcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_address", property="custAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_createtime", property="custCreatetime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Customer> selectAll();

    @Update({
        "update customer",
        "set cust_name = #{custName,jdbcType=VARCHAR},",
          "cust_user_id = #{custUserId,jdbcType=BIGINT},",
          "cust_create_id = #{custCreateId,jdbcType=BIGINT},",
          "cust_source = #{custSource,jdbcType=VARCHAR},",
          "cust_industry = #{custIndustry,jdbcType=VARCHAR},",
          "cust_level = #{custLevel,jdbcType=VARCHAR},",
          "cust_linkman = #{custLinkman,jdbcType=VARCHAR},",
          "cust_phone = #{custPhone,jdbcType=VARCHAR},",
          "cust_mobile = #{custMobile,jdbcType=VARCHAR},",
          "cust_zipcode = #{custZipcode,jdbcType=VARCHAR},",
          "cust_address = #{custAddress,jdbcType=VARCHAR},",
          "cust_createtime = #{custCreatetime,jdbcType=TIMESTAMP}",
        "where cust_id = #{custId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Customer record);
}