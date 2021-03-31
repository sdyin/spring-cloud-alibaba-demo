package com.sdyin.mall.user.controller;

import com.sdyin.mall.common.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: liuye
 * @time: 2021/3/31$ 下午3:36$
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    //用户-订单映射
    public static Map<Integer, Integer> map = new HashMap();
    static {
        map.put(1,1);
        map.put(2,2);
    }

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 根据用户id查询订单详情
     *
     * @param userId
     * @return
     */
    @GetMapping("/findOrderByUserId/{userId}")
    public Result findOrderByUserId(@PathVariable("userId") Integer userId) {
        log.info("[执行根据用户id查询订单详情] userId:{}", userId);
        Integer orderId = map.get(userId);
        String url = "http://mall-order-service/order/findOrderByOrderId/" + orderId;
        Result result = restTemplate.getForObject(url, Result.class);
        return result;
    }
}
