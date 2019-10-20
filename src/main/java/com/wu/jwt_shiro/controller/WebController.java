package com.wu.jwt_shiro.controller;

import com.wu.jwt_shiro.entity.User;
import com.wu.jwt_shiro.service.AuthService;
import com.wu.jwt_shiro.util.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Qwu
 */
@Slf4j
@RestController
public class WebController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public R register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public R login(String username, String password) {
        return authService.loginResult(username, password);
    }

    @GetMapping("/article")
    public R article() {
        return authService.article();
    }

    @GetMapping("/require_auth")
    @RequiresAuthentication
    public R requireAuth() {
        return authService.requireAuth();
    }

    @GetMapping("/require_role")
    @RequiresRoles("ROLE_ADMIN")
    public R requireRole() {
        return authService.requireRole();
    }

    @GetMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
    public R requirePermission() {
        return authService.requirePermission();
    }

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public R unauthorized() {
        return new R(401, "Unauthorized", null);
    }
}
