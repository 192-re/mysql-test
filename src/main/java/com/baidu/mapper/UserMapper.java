package com.baidu.mapper;

import com.baidu.entity.User;

import java.util.List;

public interface UserMapper {

    public List<User> selectAllUsers();

    public void insert(User u);
    public void deleteById(Integer id);

    public Integer count();
    
}
