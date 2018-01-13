package com.example.demo.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by hongjong-wan on 2018. 1. 13..
 */
@Service
public class CacheService {

    @Cacheable(value = "messageCache", condition = "'trumpet'.equals(#instrument)")
    public String play(final String instrument) {
        System.out.println("Executing: " + this.getClass().getSimpleName() + ".play(" + instrument + ")");
        return "paying " + instrument + "!";
    }
}
