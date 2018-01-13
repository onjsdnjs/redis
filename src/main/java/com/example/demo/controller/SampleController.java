package com.example.demo.controller;

import com.example.demo.service.CacheService;
import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hongjong-wan on 2018. 1. 13..
 */
@Controller
public class SampleController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private CacheService cacheService;

    @ResponseBody
    @RequestMapping("/")
    public String index() {

        return String.valueOf(redisService.getVisitCount());

    }

    @ResponseBody
    @RequestMapping("/cacheTest")
    public String cacheTest() {

        System.out.println("message: " + cacheService.play("trumpet"));
        System.out.println("message: " + cacheService.play("trumpet"));
        System.out.println("message: " + cacheService.play("guitar"));
        System.out.println("message: " + cacheService.play("guitar"));


        return "Done.";
    }
}
