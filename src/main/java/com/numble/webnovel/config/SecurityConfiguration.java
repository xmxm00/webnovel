package com.numble.webnovel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

    private final JwtTokenProvider jwtTokenProvider;

    public SecurityConfiguration(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // REST API
        httpSecurity.httpBasic().disable()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/users/signin","/users/signup", "/exception").permitAll()
                .antMatchers(HttpMethod.GET, "/novels/**").permitAll()

                .antMatchers("**exception**").permitAll()

                .anyRequest().hasRole("ADMIN")
//                .and()
//                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())
//                .and()
//                .exceptionHandling().accessDeniedHandler(new CustomAuthenticationEntryPoint())

                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
}
