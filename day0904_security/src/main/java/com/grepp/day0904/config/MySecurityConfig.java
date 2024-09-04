package com.grepp.day0904.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration//예전 xml로 설정하던 항목들의 자바버전
@EnableWebSecurity// DispatcherServlet보다도 더 먼저 진행되어야 하는 설정이라 tomcat이 읽고 반영해 줘야한다는 뜻.
public class MySecurityConfig {
}
