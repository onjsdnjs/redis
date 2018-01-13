package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JongwanApplication {
	/*
		To Do

		Question


		Finishd
		1. 레디스템플릿에 Operation 종류가 많은 이유?
		    -> value에 데이터형에 따라 사용할 Operation을 결정하면된다

		     저장되는 Value가 단순한 Object가 아니라 자료구조를 갖는다
            redis가 지원하는 데이타 형은 아래와 같이 5가지가 있다.

             -> String, List, Set, Sorted set, Hashes
        2. setKeySerializer, setValueSerializer 어떤거 사용할지 어떻게 판단
		  -> key, value를 레디스에 저장하거나 불러올때 어떤식으로 저장 불러올지(string, json(객체) 등)를 나타낸다
		      특히 커스텀 클래스를 저장할 때, JacksonJsonRedisSerializer를 이용하면 유용하게 쓸 수 있다.

		3. 레디스 캐시 이용법
		   -> @EnableCaching + 캐시매니저 등록 + @Cacheable

		4. String의 valueOf와 parse 차이

          -> valueOf(String)은 객체를 반환(new Integer()), parseInt(String)은 기본 자료형(int) 반환

        5. @Resource, @Autowired
           -> @Autowired는 스프링 프레임워크 어노테이션이다. 그렇기 때문에 스프링을 사용하지 않는 환경에서는 @Resource를 사용해야 한다.

		6. JedisPoolConfig의 역할?
		  -> 커넥션객체를 모아두는 풀에대한 설정을 하는 역할


	 */
	public static void main(String[] args) {
		SpringApplication.run(JongwanApplication.class, args);
	}
}
