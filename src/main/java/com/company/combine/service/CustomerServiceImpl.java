package com.company.combine.service;

import com.company.combine.mapper.SysUserMapper;
import com.company.combine.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuqun on 2017/8/1.
 */
@Service
public class CustomerServiceImpl {

    @Autowired
    private SysUserMapper sysUserMapper;

    public SysUser selectByPrimaryKey(Long key) {
        return sysUserMapper.selectByPrimaryKey(key);
    }

}
