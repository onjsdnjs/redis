package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JongwanApplication {
	/*
		To Do
		1. JedisPoolConfig의 역할?
		  -> 커넥션을 위해 필요한Jedis 객체를 모아두는 역할

         2. 레디스 캐시 이용법

		Question


		Finished
		1. 레디스템플릿에 Operation 종류가 많은 이유?
		    -> value에 데이터형에 따라 사용할 Operation을 결정하면된다

		     저장되는 Value가 단순한 Object가 아니라 자료구조를 갖는다
            redis가 지원하는 데이타 형은 아래와 같이 5가지가 있다.

             -> String, List, Set, Sorted set, Hashes
        2. setKeySerializer, setValueSerializer 어떤거 사용할지 어떻게 판단
		  -> key, value를 레디스에 저장하거나 불러올때 어떤식으로 저장 불러올지(string, json(객체) 등)를 나타낸다
		      특히 커스텀 클래스를 저장할 때, JacksonJsonRedisSerializer를 이용하면 유용하게 쓸 수 있다.
	 */
	public static void main(String[] args) {
		SpringApplication.run(JongwanApplication.class, args);
	}
}
