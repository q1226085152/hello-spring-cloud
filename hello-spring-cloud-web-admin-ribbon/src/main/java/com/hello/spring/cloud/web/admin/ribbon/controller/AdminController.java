package com.hello.spring.cloud.web.admin.ribbon.controller;

import com.hello.spring.cloud.web.admin.ribbon.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdminController {
    @Resource
    private AdminService adminService;

    @GetMapping("hi")
    public String sayHi(String message) {
        return adminService.sayHi(message);
    }
}
