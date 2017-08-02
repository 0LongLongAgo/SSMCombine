package com.company.combine.controller;

import com.company.combine.mapper.SysUserMapper;
import com.company.combine.model.SysUser;
import com.company.combine.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liuqun on 2017/8/1.
 */
@Controller
@RequestMapping("customer")
public class CustomerController {


    @Autowired
    CustomerServiceImpl customerService;
    /**
     * 显示用户列表
     *
     * @return
     */
    @RequestMapping("list")
    public String queryCustomerList(Model model) {
        SysUser sysUser = customerService.selectByPrimaryKey(5L);
        model.addAttribute("username", sysUser.getUserName());
        return "index1";
    }

}
