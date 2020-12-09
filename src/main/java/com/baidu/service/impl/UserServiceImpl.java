package com.baidu.service.impl;

import com.baidu.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void delete(String id) {
        System.out.println("开启事务");
        System.out.println("删除的"+id);
        System.out.println("关闭事务");
    }
}
