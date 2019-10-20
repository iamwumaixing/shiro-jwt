package com.wu.jwt_shiro.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Shiro 用户名密码的载体
 *
 * @author Qwu
 */
public class JWTToken implements AuthenticationToken {

    /**
     * 密钥
     */
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
