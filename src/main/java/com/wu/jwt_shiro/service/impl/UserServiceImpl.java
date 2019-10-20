package com.wu.jwt_shiro.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wu.jwt_shiro.entity.User;
import com.wu.jwt_shiro.mapper.UserMapper;
import com.wu.jwt_shiro.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Qwu
 * @since 2019-10-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectOne(Wrappers.<User>query().lambda().eq(User::getUsername,username));
    }
}
