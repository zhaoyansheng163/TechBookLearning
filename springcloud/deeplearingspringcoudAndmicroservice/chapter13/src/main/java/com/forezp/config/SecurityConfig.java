
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
				.formLogin().loginPage("/login").failureUrl("/login-error")    //未通过认证的用户会被重定向到 /login
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
		//------内存方式1start
//		auth
//			.inMemoryAuthentication()
//				.withUser("forezp").password("123456").roles("USER")
//				.and().withUser("admin").password("123456").roles("ADMIN","USER");
		//------内存方式1end

		//------内存方式2start
		//auth.userDetailsService(userDetailsService());
		//------内存方式2end

		auth.userDetailsService(userDetailsService);  //------数据库方式,注意  UserService  是UserDetailsService的实现
	}
	// @formatter:on


	//------内存方式2start
//	@Bean
//	public UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(); // 在内存中存放用户信息
//		manager.createUser(User.withUsername("forezp").password("123456").roles("USER").build());
//		manager.createUser(User.withUsername("admin1").password("123456").roles("ADMIN").build());  //只有ADMIN角色权限
//		manager.createUser(User.withUsername("admin").password("123456").roles("ADMIN","USER").build());  //有ADMIN和USER角色权限
//		return manager;
//	}
}
