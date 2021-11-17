package com.sdyin.dubbo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description:
 * @Author: liuye
 * @time: 2021/11/17$ 9:47 下午$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 7503312941584185448L;

    private String name;

    private Integer age;
}
