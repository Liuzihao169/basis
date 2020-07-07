package com.kuake.concurrent.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuzihao
 * @create 2020-04-15-13:34
 */
@Service
@Slf4j
public class ProdectService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void insert() {
        try {
            // (1001,"饼干",12.0,100,123123,now());
            Object [] obj = {1001,"饼干",12.0,100,123123,"2020-01-01"};
            jdbcTemplate.update("insert into products values (?,?,?,?,?,?)",obj);

            // insert into users values(123456,"liuzihao","123456",001,'liuzihao@qq.com',"109090909");

            int i = 1/0;

            jdbcTemplate.update("insert into users values(001,\"liuzihao\",\"123456\",001,'liuzihao@qq.com',\"109090909\")");

        }catch (Exception ex){
            log.error("插入数据发生异常");
            throw  new RuntimeException("空指针异常",ex);
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public void insert2(){
        Object [] obj = {10011,"饼干",12.0,100,123123,"2020-06-05"};
        jdbcTemplate.update("insert into products values (?,?,?,?,?,?)",obj);
        int i = 1/0;

    }

}
