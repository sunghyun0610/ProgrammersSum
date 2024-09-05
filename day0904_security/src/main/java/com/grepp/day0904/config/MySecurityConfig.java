package com.grepp.day0904.config;

import com.grepp.day0904.util.SHFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

@Configuration//예전 xml로 설정하던 항목들의 자바버전
@EnableWebSecurity// DispatcherServlet보다도 더 먼저 진행되어야 하는 설정이라 tomcat이 읽고 반영해 줘야한다는 뜻.
public class MySecurityConfig {
    @Autowired
    public SHFilter shFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.cors(AbstractHttpConfigurer::disable)// cors는 일단 비활성화. 추후 프론트와 연결할 때 프론트 서버 CORS만 풀고 나머지는 불허해야 함.
                .csrf(AbstractHttpConfigurer::disable)//cookie등을 활용하고 있지 않아서 csrf비활성화. 추후 csrf공격을 막고싶으면 여기 활성화하고 쿠키등의 설정을 해야
                .httpBasic(AbstractHttpConfigurer::disable)//basic인증이 아니라 jwt인증이기때문.
                .sessionManagement(AbstractHttpConfigurer::disable)//session기반 아님
                .authorizeHttpRequests(req->{
                    req.requestMatchers("/auth/**").permitAll();// 로그인 하러 오는 애한테 왜 토큰없냐고 하면 안된다
                    req.anyRequest().authenticated();//나머지는 다 인증되어야 들어오게 할거임ㅁ
                })
                .addFilterAfter(shFilter, CorsFilter.class)
                .build();
    }
}
