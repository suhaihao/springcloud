package com.jf.spb.config;

import com.jf.spb.security.UsernamePasswordAuthenticationProcessingFilter;
import com.jf.spb.security.UsernamePasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 安全框架架构
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 权限规则
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //设置禁用crsf
        http.csrf().disable()
                //设置放开静态资源
                .authorizeRequests()
                .antMatchers("/h-ui/**").permitAll()
                .antMatchers("/h-ui.admin/**").permitAll()
                .antMatchers("/lib/**").permitAll()
                //所有连接都需要登陆
                .anyRequest().authenticated()
                //默认登陆连接
                .and().formLogin().loginPage("/login")
                //登陆成功跳转连接
                .successHandler(new ForwardAuthenticationSuccessHandler("/index"))
                .failureUrl("/login?erro=true")
                .permitAll()
                //设置session过期路径
                .and().sessionManagement().invalidSessionUrl("/login")
                // 设置登出的路径和登出成功后访问的路径
                .and().logout().logoutSuccessUrl("/login").permitAll()
                //登陆绑定参数
                .and().addFilter(getPreAuthenticatedProcessingFilter());
    }

    /**
     * 认证规则
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.authenticationProvider(new UsernamePasswordAuthenticationProvider());
    }
    /**
     * 为验证拦截器设置AuthenticationManager (由于用了springboot注入方式)
     * @return
     * @throws Exception
     */
    private UsernamePasswordAuthenticationProcessingFilter getPreAuthenticatedProcessingFilter() throws Exception {
        UsernamePasswordAuthenticationProcessingFilter filter = new UsernamePasswordAuthenticationProcessingFilter();
        filter.setAuthenticationManager(this.authenticationManagerBean());
        return  filter;
    }

}
