package com.example.securitydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author shipp
 * @descript
 * @create 2019-04-24 11:17
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * @Description: HttpSecurity定义了哪些URL路径应该被拦截
     * @Param:
     * @return:
     * @Author: shipeipei
     * @Date: 2019/4/24
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {//
        http.authorizeRequests()
                //允许所有人访问
                .antMatchers("/","/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //作为登录入口 也允许被访问 剩下的/hello  则需要登录后才可以访问
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    //内存中配置一个用户 实际开发中要读库  这边用于测试
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        //spring security 5.0之后不支持
        //auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER");
        //auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("admin").password("admin").roles("USER");
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("USER");
    }

    /*@Bean
    @Override
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder().username("admin").password("admin").roles("USER").build();
        return new InMemoryUserDetailsManager(user);
    }*/
}
