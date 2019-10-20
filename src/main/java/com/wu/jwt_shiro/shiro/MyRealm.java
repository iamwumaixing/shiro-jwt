package com.wu.jwt_shiro.shiro;

import com.wu.jwt_shiro.entity.Role;
import com.wu.jwt_shiro.entity.User;
import com.wu.jwt_shiro.entity.UserRole;
import com.wu.jwt_shiro.service.IRoleService;
import com.wu.jwt_shiro.service.IUserService;
import com.wu.jwt_shiro.service.UserRoleService;
import com.wu.jwt_shiro.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * realm 的用于处理用户是否合法的这一块,需要自己实现
 *
 * @author Qwu
 */
@Slf4j
@Service
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserRoleService userRolesService;

    @Autowired
    private IRoleService roleService;

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = null;
        try {
            String username = JWTUtil.getUsername(principalCollection.toString());
            User user = userService.selectByUsername(username);
            //1 查询出用户实体
            System.out.println("1用户实体"+user.toString());
            simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            List<UserRole> list = userRolesService.selectRolesByUserId(user.getId());
            Set<String> permission = null;
            for (UserRole userRoles :
                    list) {
                //2 查询出用户对应的 userrole
                System.out.println("2userRole-Id"+userRoles.toString());
                Role role = roleService.getById(userRoles.getRolesId());
                // 3 username
                System.out.println("3roleName"+role.toString());
                simpleAuthorizationInfo.addRole(role.getName());
                permission = new HashSet<>(Arrays.asList(role.getPermission().split(",")));
            }
            simpleAuthorizationInfo.addStringPermissions(permission);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     * @param auth
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }

        User user = userService.selectByUsername(username);
        if (user == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (!JWTUtil.verify(token,username,user.getPassword())){
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token,token,"my_realm");
    }

    /**
     * 大坑！必须重写此方法，不然Shiro会报错
     *
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }


}
