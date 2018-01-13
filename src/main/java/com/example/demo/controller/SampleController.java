package com.example.demo.controller;

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

    @ResponseBody
    @RequestMapping(value = "/")
    public String index() {

        return String.valueOf(redisService.getVisitCount());

    }
}
