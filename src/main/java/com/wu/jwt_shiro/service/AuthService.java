package com.wu.jwt_shiro.service;

import com.wu.jwt_shiro.entity.User;
import com.wu.jwt_shiro.util.R;

/**
 * @author Qwu
 */
public interface AuthService {
    /**
     * 登录
     *
     * @param username 账号
     * @param password 密码
     * @return R
     */
    R loginResult(String username, String password);

    /**
     * 所有人都可以访问，但是用户与游客看到的内容不同
     *
     * @return R
     */
    R article();

    /**
     * 登入的用户才可以进行访问
     *
     * @return
     */
    R requireAuth();

    /**
     * admin的角色用户才可以登入
     *
     * @return
     */
    R requireRole();

    /**
     * 拥有view和edit权限的用户才可以访问
     *
     * @return
     */
    R requirePermission();

    /**
     * 注册
     * @param user
     * @return
     */
    R register(User user);
}
