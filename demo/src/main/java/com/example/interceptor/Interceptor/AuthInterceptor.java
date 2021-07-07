package com.example.interceptor.Interceptor;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.interceptor.annotation.Auth;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.UriComponentsBuilderMethodArgumentResolver;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        
        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI()).build().toUri();

     
        log.info("request ulr : {}", url);
        boolean hasAnnotaion = checkAnnotation(handler, Auth.class);
        log.info("has annotaion : {}", hasAnnotaion);
        if(hasAnnotaion) {
            String query = uri.getQuery();
            if(query.equals("name-mingg")) {
                return true;
            }
        } return false;
        // return true;
    }
    private boolean checkAnnotation(Object handler, Class clazz) {

        //resource javascript, html, 
        if(handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if(null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)) {
            return true;
        }
        return false;
    }
}
