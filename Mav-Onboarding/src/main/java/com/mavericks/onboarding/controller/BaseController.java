package com.mavericks.onboarding.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//BaseController.java
@RestController
@RequestMapping("/api/v1")
public class BaseController {
 
 protected String generateId() {
     return UUID.randomUUID().toString().substring(0, 20);
 }
}



