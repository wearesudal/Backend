package com.sudal.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
            .headers((headers) -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
            .authorizeHttpRequests(auth -> auth
//                    .requestMatchers(
//                            new AntPathRequestMatcher("/"),
//                            new AntPathRequestMatcher("/css/**"),
//                            new AntPathRequestMatcher("/images/**"),
//                            new AntPathRequestMatcher("/js/**")
//                            //new AntPathRequestMatcher("/h2-console/**"),
//
//                    ).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/swagger-ui.**")).permitAll()
                    //.anyRequest().authenticated());
            );
        return http.build();
    }
}