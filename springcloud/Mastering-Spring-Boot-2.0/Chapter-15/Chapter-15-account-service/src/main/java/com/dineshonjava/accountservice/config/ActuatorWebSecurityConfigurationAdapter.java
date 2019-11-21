package com.dineshonjava.accountservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author jiashubing
 * @since 2018/7/16
 */
@Configuration
@EnableWebSecurity
public class ActuatorWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //普通的接口不需要校验
                .antMatchers("/account/**").permitAll()
                // swagger页面需要添加登录校验
                .antMatchers("/actuator/**").authenticated()
                .and()
                .formLogin();
    }
}