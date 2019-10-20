package com.wu.jwt_shiro.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.wu.jwt_shiro.entity.User;
import com.wu.jwt_shiro.service.AuthService;
import com.wu.jwt_shiro.service.IUserService;
import com.wu.jwt_shiro.util.JWTUtil;
import com.wu.jwt_shiro.util.R;
import com.wu.jwt_shiro.util.UnauthorizedException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Qwu
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private IUserService userService;

    @Override
    public R loginResult(String username, String password) {
        User user = userService.selectByUsername(username);
        if (user.getPassword().equals(SecureUtil.md5(password))) {
            return new R(200, "Login success", JWTUtil.sign(username, password));
        } else {
            throw new UnauthorizedException();
        }
    }

    @Override
    public R article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return new R(200, "You are already logged in", null);
        } else {
            return new R(200, "You are guest", null);
        }
    }

    @Override
    public R requireAuth() {
        return new R(200, "You are authenticated", null);
    }

    @Override
    public R requireRole() {
        return new R(200, "You are visiting require_role", null);
    }

    @Override
    public R requirePermission() {
        return new R(200, "You are visiting permission require edit,view", null);
    }

    @Override
    public R register(User user) {
        User existUser = userService.selectByUsername(user.getUsername());
        if (existUser != null) {
            return new R(200, "username already exists");
        }
        String password = SecureUtil.md5(user.getPassword());
        user.setPassword(password);
        userService.save(user);
        return new R(200, "register successful");
    }
}
