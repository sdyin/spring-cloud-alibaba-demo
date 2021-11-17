package com.sdyin.dubbo.service;

import com.google.common.collect.Lists;
import com.sdyin.dubbo.api.UserService;
import com.sdyin.dubbo.entity.User;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;

/**
 * @Description:
 * @Author: liuye
 * @time: 2021/11/17$ 9:54 下午$
 */
@DubboService
public class UserServiceImpl implements UserService {

    /**
     * 查询用户列表
     *
     * @return
     */
    @Override
    public List<User> list() {
        User user = new User("sdyin", 18);
        List<User> list = Lists.newArrayList(user);
        return list;
    }
}
