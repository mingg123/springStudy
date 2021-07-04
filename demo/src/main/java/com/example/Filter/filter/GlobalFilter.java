package com.example.Filter.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Slf4j
// @Component

//ResponseBody에 api/filteruser 하위 모든 폴더에 있는 것은 나오지만 api/temp는 나오지 않음
@WebFilter(urlPatterns = "/api/filteruser/*")
public class GlobalFilter implements Filter{


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

                ContentCachingRequestWrapper  httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
                ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper ((HttpServletResponse) response);

                Logger logger = LoggerFactory.getLogger(this.getClass());
                
                //전처리
                chain.doFilter(httpServletRequest, httpServletResponse);

                String url = httpServletRequest.getRequestURI();

                  //후처리
                String reqContent = new String(httpServletRequest.getContentAsByteArray());
                
                logger.info("request status : {}, responseBody : {}", url, reqContent);
                String resContent = new String(httpServletResponse.getContentAsByteArray());

                int httpStatus = httpServletResponse.getStatus();
                
                httpServletResponse.copyBodyToResponse();
                logger.info("response status : {}, responseBody : {}", httpStatus, resContent);

              

                // httpServletResponse.
        // TODO Auto-generated method stub
        
    }
    
}
