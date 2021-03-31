package com.sdyin.mall.common.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author liuye
 * @Date 2019/9/21 9:46
 **/
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = -1170312739269962690L;
    /**
     * 响应编码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 响应内容
     */
    private Object data;

    /**
     * 响应失败
     *
     * @param resultCode
     * @param errorDesc
     * @return
     */
    public static Result failed(int resultCode, String errorDesc) {
        Result result = new Result();
        result.setCode(resultCode);
        result.setMessage(errorDesc);
        return result;
    }

    /**
     * 响应成功
     *
     * @return
     */
    public static Result success() {
        Result result = new Result();
        result.setCode(1);
        result.setMessage("响应成功");
        return result;
    }

    /**
     * 响应成功且有响应内容
     *
     * @return
     */
    public static Result successData(Object data) {
        Result result = new Result();
        result.setCode(1);
        result.setMessage("响应成功");
        result.setData(data);
        return result;
    }
}
