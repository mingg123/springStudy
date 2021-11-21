package com.example.springfilter.interceptor;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.springfilter.annotation.Auth;
import com.example.springfilter.exception.AuthException;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Authinterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String url = request.getRequestURI();

        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI()).query(request.getQueryString()).build()
                .toUri();
        log.info("interceptor!");
        log.info("request url : {}", url);

        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has annotation : {}", hasAnnotation);
        // 조건 추가

        // 나의 서버는 모두 public인데 private일 경우 name이 minji가 아니면 404에러를 낸다.
        // (GolbalExceptionHandler.java)
        if (hasAnnotation) {
            // 권한 체크
            String query = uri.getQuery();
            log.info("query : {}", query);
            if (query.equals("name=minji")) {
                return true;
            }
            // return false;
            throw new AuthException();
        }
        return true;
    }

    private boolean checkAnnotation(Object handler, Class clazz) {

        // resource javascript, html
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if (null != handlerMethod.getMethodAnnotation(clazz)
                || null != handlerMethod.getBeanType().getAnnotation(clazz)) {
            return true;
        }
        return false;
    }
}
