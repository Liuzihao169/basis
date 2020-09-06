package com.kuake.concurrent;

import com.kuake.concurrent.service.ProdectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.SendingContext.RunTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class ConcurrentApplicationTests {

    @Autowired
    private DataSource source;

    @Autowired
    private ProdectService prodectService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Qualifier("myRedisTemplate")
    @Autowired
    private RedisTemplate myRedisTemplate;
    @Test
    public void contextLoads() throws Exception{
        prodectService.insert();
    }

    @Test
    public void test2(){
        redisTemplate.opsForValue().set("hello","his hello world");
    }

    @Test
    public void test3(){
        System.out.println(redisTemplate.opsForValue().get("hello"));
    }

    @Test
    public void test4(){
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
