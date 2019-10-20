package com.wu.jwt_shiro.service.impl;

import com.wu.jwt_shiro.entity.Role;
import com.wu.jwt_shiro.mapper.RoleMapper;
import com.wu.jwt_shiro.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Qwu
 * @since 2019-10-19
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
