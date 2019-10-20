package com.wu.jwt_shiro.util;

/**
 * 手动抛出异常
 *
 * @author Qwu
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }
}
