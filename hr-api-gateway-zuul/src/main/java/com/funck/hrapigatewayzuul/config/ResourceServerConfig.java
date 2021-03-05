package com.funck.hrapigatewayzuul.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@RequiredArgsConstructor
@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String[] PUBLIC = {"/hr-oauth/oauth/token"};
    private static final String[] OPERATOR = {"/hr-worker/**"};
    private static final String[] ADMIN = {"/hr-payroll/**", "/hr-user/**"};

    private final JwtTokenStore tokenStore;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(PUBLIC).permitAll()
                .antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("ADMIN", "OPERATOR")
                .antMatchers(ADMIN).hasRole("ADMIN")
                .anyRequest().authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.tokenStore(tokenStore);
    }
}
