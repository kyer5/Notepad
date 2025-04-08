package com.goormthon.knu.web1.notepad.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // CORS를 적용할 URL 패턴 정의
                .allowedOriginPatterns("*") // 자원 공유를 허락할 origin 지정 ('*' -> 모든 origin 허락)
                .allowedMethods("GET", "POST", "PATCH", "DELETE") // 허용할 HTTP method 지정
                .allowedHeaders("Authorization", "Content-Type") // 클라이언트 측의 CORS 요청에 허용되는 헤더 지정
                .exposedHeaders("Custom-Header") // 클라이언트 측의 응답에서 노출되는 헤더 지정
                .allowCredentials(true) // 클라이언트 측에 대한 응답에 credentials(ex. 쿠키, 인증 헤더) 포함 가능 여부 지정
                .maxAge(3600); // 원하는 시간만큼 pre-flight 리퀘스트를 캐싱
    }
}
