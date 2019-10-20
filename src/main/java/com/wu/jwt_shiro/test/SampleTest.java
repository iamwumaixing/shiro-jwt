package com.wu.jwt_shiro.test;

import com.wu.jwt_shiro.entity.Role;
import com.wu.jwt_shiro.entity.User;
import com.wu.jwt_shiro.entity.UserRole;
import com.wu.jwt_shiro.mapper.UserRoleMapper;
import com.wu.jwt_shiro.service.IRoleService;
import com.wu.jwt_shiro.service.IUserService;
import com.wu.jwt_shiro.service.UserRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Qwu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    private UserRoleService userRolesService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserService userService;

    @Test
    public void testSelect() {
        List<UserRole> list = userRolesService.selectRolesByUserId(4);
        for (UserRole user :
                list) {
            Role role = roleService.getById(user.getRolesId());
            System.out.println(role.toString());
        }
    }
}
