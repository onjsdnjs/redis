package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JongwanApplicationTests {

    /*
    레디스는 value에 여러가지 자료형이 있는데요.
    자료형에 맞는 데이터를 가져오기 쉽게 Opration을 구분해놓았다.
     */


    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOperations;

    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOperations;

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, String> hashOperations;

    @Resource(name = "redisTemplate")
    private SetOperations<String, String> setOperations;

    @Resource(name = "redisTemplate")
    private ZSetOperations<String, String> zSetOperations;


    @Before
    public void init() {
        //list put
        listOperations.rightPush("category", "자기소개");
        listOperations.rightPush("category", "취미소개");
        listOperations.rightPush("category", "목표소개");
        listOperations.rightPush("category", "알고싶은 사람");
        //hash put
        hashOperations.put("user", "name", "마법사");
        hashOperations.put("user", "age", "30");
        // set put
        setOperations.add("hobby", "개발");
        setOperations.add("hobby", "잠");
        setOperations.add("hobby", "쇼핑");
        //zset put
        zSetOperations.add("wish", "차메시 프로젝트 성공적 마무리", 1);
        zSetOperations.add("wish", "개발 실력 급상승", 2);
        zSetOperations.add("wish", "경력직 채용", 3);
        zSetOperations.add("wish", "연애", 4);
    }


    @Test
    public void redisTest1() {
        String category = listOperations.leftPop("category");
        StringBuilder stringBuilder = new StringBuilder();
        while (category != null) {
            switch (category) {
                case "자기소개":
                    Map<String, String> intro = hashOperations.entries("user");
                    stringBuilder.append("\n******자기소개********");
                    stringBuilder.append("\n이름은 ");
                    stringBuilder.append(intro.get("name"));
                    stringBuilder.append("\n나이는 ");
                    stringBuilder.append(intro.get("age"));
                    break;
                case "취미소개":
                    Set<String> hobbys = setOperations.members("hobby");
                    stringBuilder.append("\n******취미소개******\n");
                    stringBuilder.append("취미는");
                    for (String hobby : hobbys) {
                        stringBuilder.append("\n");
                        stringBuilder.append(hobby);
                    }
                    break;
                case "목표소개":
                    Set<String> wishes = zSetOperations.range("wish", 0, 2);
                    stringBuilder.append("\n******소망소개******");
                    int rank = 1;
                    for (String wish : wishes) {
                        stringBuilder.append("\n");
                        stringBuilder.append(rank);
                        stringBuilder.append("등 ");
                        stringBuilder.append(wish);
                        rank++;
                    }
                    break;
                case "알고싶은 사람":
                    stringBuilder.append("\n!!! 알고싶은 사람");
                    zSetOperations.incrementScore("wish", "경력직 채용", -2);
                    listOperations.rightPush("category", "목표소개");
                    break;
                default:
                    stringBuilder.append("none");
            }
            category = listOperations.leftPop("category");
        }
        System.out.println(stringBuilder.toString());
    }


}
