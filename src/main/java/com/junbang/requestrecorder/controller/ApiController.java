package com.junbang.requestrecorder.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

  @PostMapping("/root")
  public ResponseEntity<String> call(@RequestBody String request) {
    String response = request;
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
  }
}
