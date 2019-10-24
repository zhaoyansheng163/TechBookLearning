
package com.forezp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
					.antMatchers("/css/**", "/index").permitAll()
					.antMatchers("/user/**").hasRole("USER")
				    .antMatchers("/blogs/**").hasRole("USER")
					.and()
				.formLogin().loginPage("/login").failureUrl("/login-error")
				.and()
				.exceptionHandling().accessDeniedPage("/401");
		http.logout().logoutSuccessUrl("/");
	}
	// @formatter:on

	// @formatter:off
	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//------内存方式start
//		auth
//			.inMemoryAuthentication()
//				.withUser("forezp").password("123456").roles("USER");
//
//		auth.userDetailsService(userDetailsService());
		//------内存方式end

		auth.userDetailsService(userDetailsService);  //------数据库方式
	}
	// @formatter:on


//	@Bean
//	public UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(); // 在内存中存放用户信息
//		manager.createUser(User.withUsername("forezp").password("123456").roles("USER").build());
//		manager.createUser(User.withUsername("admin").password("123456").roles("ADMIN","USER").build());  //只有ADMIN角色权限
//		//manager.createUser(User.withUsername("admin").password("123456").roles("ADMIN","USER").build());  //有ADMIN和USER角色权限
//		return manager;
//	}
}
