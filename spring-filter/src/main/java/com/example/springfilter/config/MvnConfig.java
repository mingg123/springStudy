package com.example.springfilter.config;

import com.example.springfilter.interceptor.Authinterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MvnConfig implements WebMvcConfigurer {

    private final Authinterceptor authinterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // registry.addInterceptor(authinterceptor);
        // 빼거나 추가한다 주소를
        registry.addInterceptor(authinterceptor).addPathPatterns("/interceptorapi/private/*");
    }
}
