package com.junbang.requestrecorder.config;

import com.junbang.requestrecorder.aop.RequestRecordInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class RequestConfigurer implements WebMvcConfigurer {

  private final RequestRecordInterceptor requestRecordInterceptor;

  public RequestConfigurer(RequestRecordInterceptor requestRecordInterceptor) {
    this.requestRecordInterceptor = requestRecordInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(requestRecordInterceptor)
        .addPathPatterns("/**");
  }
}
