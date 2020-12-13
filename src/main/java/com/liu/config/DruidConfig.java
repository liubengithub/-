package com.liu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author root
 * @create 2020-12-04 15:42
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控  : 相当于web.xml ServletRegistrationBean
    //因为SpringBoot内置了servlet容器，所以没有web.xml，替代方法：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        //后台需要有人登录---配置账号密码
        HashMap<String, String> map = new HashMap<>();
        //增加配置
        map.put("loginUsername","admin");  //登录key是固定的loginUsername  loginPassword
        map.put("loginPassword","123456");

        //允许谁可以访问
        map.put("allow","");

        //禁止谁能访问    map.put("liu","192.168.1.1");

        bean.setInitParameters(map);
        return bean;
    }
    //filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        //可以过滤那些请求
        Map<String,String> initParameters = new HashMap<>();
        //这些东西不进行统计
        initParameters.put("exclusion","*.js,*.css,/druid/*");
        bean.setInitParameters(initParameters);
        return bean;
    }

}

