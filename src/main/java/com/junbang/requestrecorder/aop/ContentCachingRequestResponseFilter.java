package com.junbang.requestrecorder.aop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ContentCachingRequestResponseFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    ContentCachingRequestWrapper contentCachingRequestWrapper = new ContentCachingRequestWrapper(request);
    ContentCachingResponseWrapper contentCachingResponseWrapper = new ContentCachingResponseWrapper(response);
    filterChain.doFilter(contentCachingRequestWrapper, contentCachingResponseWrapper);
  }
}