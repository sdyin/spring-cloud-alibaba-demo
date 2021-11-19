package com.sdyin.mall.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description:
 * @Author: liuye
 * @time: 2021/11/18$ 10:01 下午$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 6320788372723118756L;

    private Long id;

    private String name;

    private Integer age;

}
