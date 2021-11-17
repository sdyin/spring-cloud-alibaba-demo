package com.sdyin.mall.user.service.feign;

import com.sdyin.mall.common.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: liuye
 * @time: 2021/11/17$ 11:15 上午$
 */
@Slf4j
@Service
public class OrderFeignFallbackService implements OrderFeignService{

    @Override
    public Result findOrderByUserId(Long orderId) {
        log.error("【调用订单服务根据用户查询订单信息异常】orderId:{}", orderId);
        return Result.failed(0, "响应失败");
    }
}
