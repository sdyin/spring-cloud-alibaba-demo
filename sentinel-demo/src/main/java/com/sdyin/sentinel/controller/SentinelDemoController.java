package com.sdyin.sentinel.controller;


import com.sdyin.mall.common.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sentinel")
@Slf4j
public class SentinelDemoController {

    @GetMapping("/info/{id}")
    public Result queryById(@PathVariable("id") Long id){
        log.info("【执行查询接口】 id:{}", id);
        return Result.successData(id);
    }
}
