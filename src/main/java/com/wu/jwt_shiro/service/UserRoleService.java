package com.wu.jwt_shiro.service;

import com.wu.jwt_shiro.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Qwu
 * @since 2019-10-19
 */
public interface UserRoleService extends IService<UserRole> {

    /**
     * select
     * @param id
     * @return
     */
    List<UserRole> selectRolesByUserId(Integer id);
}
