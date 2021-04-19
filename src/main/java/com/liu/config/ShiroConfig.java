package com.liu.config;

import com.liu.shiro.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author root
 * @create 2020-12-04 20:35
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        //添加shiro的内置过滤器
        /*
        anon:无需认证就可以访问
        authc:必须认证了才能访问
        user:必须拥有   记住我  功能才能用
        perms:拥有对某个资源的权限才能访问
        role： 拥有某个角色权限才能访问
         */
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> filterChainDefinitionMap = new HashMap<String,String>();
        filterChainDefinitionMap.put("/admin/**","authc");
        filterChainDefinitionMap.put("/admin/login","anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        shiroFilterFactoryBean.setLoginUrl("/admin");
        return shiroFilterFactoryBean;
    }
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联Realm
        defaultWebSecurityManager.setRealm(userRealm);

       return defaultWebSecurityManager;
    }
    @Bean
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }
    /**
     * 密码校验规则HashedCredentialsMatcher
     * 这个类是为了对密码进行编码的 ,
     * 防止密码在数据库里明码保存 , 当然在登陆认证的时候 ,
     * 这个类也负责对form里输入的密码进行编码
     * 处理认证匹配处理器：如果自定义需要实现继承HashedCredentialsMatcher
     */
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        credentialsMatcher.setHashIterations(1024);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }
}
