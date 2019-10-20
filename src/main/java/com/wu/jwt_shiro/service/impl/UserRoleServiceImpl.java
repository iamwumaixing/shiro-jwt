package com.wu.jwt_shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wu.jwt_shiro.entity.UserRole;
import com.wu.jwt_shiro.mapper.UserRoleMapper;
import com.wu.jwt_shiro.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Qwu
 * @since 2019-10-19
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> selectRolesByUserId(Integer id) {
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id);
        return userRoleMapper.selectList(queryWrapper);
    }
}
