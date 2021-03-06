package org.cloud.panzer.config;

import org.cloud.panzer.security.BadAuthenticationEntryPoint;
import org.cloud.panzer.security.LoginSuccessHandler;
import org.cloud.panzer.security.filter.CustomAuthenticationFilter;
import org.cloud.panzer.security.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private LoginSuccessHandler loginSuccessHandler;

    @Resource
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Resource
    private LogoutSuccessHandler logoutSuccessHandler;

    @Resource
    private BadAuthenticationEntryPoint badAuthenticationEntryPoint;

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private TokenFilter tokenFilter;

    @Resource
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(loginSuccessHandler);
        filter.setAuthenticationFailureHandler(authenticationFailureHandler);
        filter.setFilterProcessesUrl("/login");

        // 这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        // 基于token，所以不需要session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                .antMatchers("/login", "/api/v1/**", "/mobile/**").permitAll().anyRequest().authenticated().and().rememberMe()
                .rememberMeServices(rememberMeServices())
                .key("INTERNAL_SECRET_KEY")
                .rememberMeServices(rememberMeServices())
                .rememberMeParameter("remember-me")
                .key("INTERNAL_SECRET_KEY").tokenValiditySeconds(1209600).and()
                .formLogin().and().exceptionHandling().authenticationEntryPoint(badAuthenticationEntryPoint).and()
                .logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler);

        // 解决不允许显示在iframe的问题
        http.headers().frameOptions().disable();
        http.headers().cacheControl();

        http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public RememberMeServices rememberMeServices() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);

        PersistentTokenBasedRememberMeServices rememberMeServices =
                new PersistentTokenBasedRememberMeServices("INTERNAL_SECRET_KEY", userDetailsService, db);

        // 该参数不是必须的，默认值为 "remember-me", 但如果设置必须和页面复选框的 name 一致
        rememberMeServices.setParameter("remember-me");
        return rememberMeServices;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) {
        // 将项目中静态资源路径开放出来
        web.ignoring().antMatchers("/api/v3/api-docs/**",
                "/uploads/**", "/assets/**", "/static/**");
    }

}
