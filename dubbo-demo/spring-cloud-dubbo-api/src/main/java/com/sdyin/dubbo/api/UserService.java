package com.sdyin.dubbo.api;

import com.sdyin.dubbo.entity.User;

import java.util.List;

/**
 * @description:
 * @author: liuye
 * @time: 2021/11/17$ 9:41 下午$
 */
public interface UserService {

    /**
     * 查询用户列表
     *
     * @return
     */
    List<User> list();
}
