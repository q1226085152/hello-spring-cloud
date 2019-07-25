package com.hello.spring.cloud.web.admin.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@Service
public class AdminService {
    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHi(String message) {
        return restTemplate.getForObject("http://hello-spring-cloud-service-admin/hi?message=" + message,String.class);
    }

    public String hiError(String message) {
        return String.format("Hi your message is : %s but request bad", message);
    }
}
