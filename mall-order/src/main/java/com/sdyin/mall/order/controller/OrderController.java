package com.sdyin.mall.order.controller;

import com.sdyin.mall.common.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liuye
 * @time: 2021/3/31$ 下午2:30$
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {


    /**
     * 根据订单id查询订单信息
     *
     * @param orderId
     * @return
     */
    @GetMapping("/findOrderByOrderId/{orderId}")
    public Result findOrderByUserId(@PathVariable("orderId") Integer orderId) {
        Integer data = 1;
        return Result.successData(data);
    }
}
