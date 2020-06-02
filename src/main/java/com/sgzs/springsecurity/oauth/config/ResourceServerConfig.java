package com.sgzs.springsecurity.oauth.config;

import cn.hutool.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author: jianyufeng
 * @description: @EnableResourceServer接管路径 http.authorizeRequest /login
 *               认证方式：令牌
 * @date: 2020/6/1 21:05
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    MyAuthenticationSucessHandler myAuthenticationSucessHandler;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()//表单登录
                .loginProcessingUrl("/login")
                .successHandler(myAuthenticationSucessHandler)
                .failureHandler((request, response, e) -> {
                    response.setStatus(HttpStatus.HTTP_INTERNAL_ERROR);
                    response.setContentType("application/json;charset=utf-8");
                    response.getWriter().write(e.getMessage());
                })
            .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
            .and()
                .csrf().disable();


    }
}
