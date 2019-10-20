package com.wu.jwt_shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wu.jwt_shiro.entity.Role;
import com.wu.jwt_shiro.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Qwu
 * @since 2019-10-17
 */
public interface IUserService extends IService<User> {
    /**
     * 通过username查询user
     * @param username
     * @return
     */
    User selectByUsername(String username);

}
