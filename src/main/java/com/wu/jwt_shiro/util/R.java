package com.wu.jwt_shiro.util;

import lombok.Data;

/**
 * 响应信息主体
 *
 * @author Qwu
 */
@Data
public class R {

    /** http 状态码 */
    private int code;

    /** 返回信息 */
    private String msg = "success";

    /** 返回的数据 */
    private Object data;

    public R(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public R(int code,Object data) {
        this.code = code;
        this.data = data;
    }

}
