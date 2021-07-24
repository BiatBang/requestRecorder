package com.junbang.requestrecorder.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
@Slf4j
public class RequestRecordService {

  public void recordRequest(HttpServletRequest request, HttpServletResponse response) {
    ContentCachingRequestWrapper requestWrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
    ContentCachingResponseWrapper responseWrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
    String requestString = new String(requestWrapper.getContentAsByteArray());
    String responseString = new String(responseWrapper.getContentAsByteArray());

    log.info("request: {}", requestString);
    log.info("response: {}", responseString);
  }
}
