package com.sdyin.mall.user.service.feign;

import com.sdyin.mall.common.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @Author: liuye
 * @time: 2021/11/17$ 10:32 上午$
 */
@FeignClient(value = "mall-order-service", path = "/order", fallback = OrderFeignFallbackService.class)
public interface OrderFeignService {

    @GetMapping("/findOrderByOrderId/{orderId}")
    Result findOrderByUserId(@PathVariable("orderId") Long orderId);
}
