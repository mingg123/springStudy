package com.example.springfilter.filter;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GolbalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Request, Response를 찍으려면 ContentCaching을 사용해야함
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper(
                (HttpServletRequest) request);
        ContentCachingResponseWrapper HttpServletResponse = new ContentCachingResponseWrapper(
                (HttpServletResponse) response);

        String url = httpServletRequest.getRequestURI();

        // 전처리
        chain.doFilter(httpServletRequest, HttpServletResponse);

        // 후처리
        // req
        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("request url : {}, request Body: {}", url, reqContent);

        String resContent = new String(HttpServletResponse.getContentAsByteArray());
        int httpStatus = HttpServletResponse.getStatus();

        // 이걸 무조건 해주어야 client쪽에 나타남. 해주지 않으면 No Content
        HttpServletResponse.copyBodyToResponse();
        log.info("response status : {}, response Body: {}", httpStatus, resContent);

    }

}
