package com.sdyin.mall.user.controller;

import com.sdyin.mall.common.entity.User;
import com.sdyin.mall.common.response.Result;
import com.sdyin.mall.user.service.feign.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope //处理@Value获取到的值无法动态感知修改问题
@Slf4j
public class UserController {

    //用户-订单映射
    public static Map<Integer, Long> map = new HashMap();
    static {
        map.put(1,1L);
        map.put(2,2L);
    }

    @Value("${user.name}")
    private String userName;

    @Value("${user.age}")
    private Integer age;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderFeignService orderFeignService;


    /**
     * 从nacos配置中心读取配置值
     *
     * @return
     */
    @GetMapping("/config/value")
    public Result getValueFromNacosConfig(){
        log.info("【读取到用户名】 userName:{}", userName);
        log.info("【读取到用户年龄】 age:{}", age);
        User user = new User(1L, userName, age);
        return Result.successData(user);
    }

    /**
     * 根据用户id查询订单详情
     *
     * @param userId
     * @return
     */
    @GetMapping("/findOrderByUserId/{userId}")
    public Result findOrderByUserId(@PathVariable("userId") Integer userId) {
        log.info("[执行根据用户id查询订单详情] userId:{}", userId);
        Long orderId = map.get(userId);
        //ribbon服务调用方式
        String url = "http://mall-order-service/order/findOrderByOrderId/" + orderId;
        Result result = restTemplate.getForObject(url, Result.class);
        return result;
    }

    /**
     * feign 方式查询订单详情
     * @param userId
     * @return
     */
    @GetMapping("/feign/findOrderByUserId/{userId}")
    public Result findOrderByUserIdFeign(@PathVariable("userId") Integer userId) {
        log.info("[feign方式执行根据用户id查询订单详情] userId:{}", userId);
        Long orderId = map.get(userId);
        //feign方式
        Result result = orderFeignService.findOrderByUserId(orderId);
        return result;
    }

    /**
     * 查询用户信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/info/{userId}")
    public Result queryUserInfo(@PathVariable("userId") Integer userId){
        User user = new User();
        user.setName("");

        return Result.successData(user);
    }



}
