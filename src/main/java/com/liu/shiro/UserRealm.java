package com.liu.shiro;

import com.liu.pojo.User;
import com.liu.service.impl.UserServiceImpl;
import com.liu.utils.MD5Utils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @author root
 * @create 2020-12-04 20:40
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserServiceImpl userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.queryUserByUsername(token.getUsername());
        if(user == null){
            return null;
        }
        //密码认证   ---shiro自己做
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                "",
                user.getPassword(),//加密前的密码
                ByteSource.Util.bytes(user.getUsername()), // 加盐后的密码,user.getUsername()作为盐值
                getName());// 指定当前 Realm 的类名

        return simpleAuthenticationInfo;
    }

}
