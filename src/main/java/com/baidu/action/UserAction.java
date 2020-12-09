package com.baidu.action;

import com.baidu.factory.BeanFactory;
import com.baidu.service.UserService;

public class UserAction {
    public String execute(){
       //UserService service = new UserServiceImpl();
        UserService service = (UserService) BeanFactory.getBean("userService");
        service.delete("1");
        return null;
    }
}
