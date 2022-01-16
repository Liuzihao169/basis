package com.kuake.concurrent.controller;

import com.kuake.concurrent.service.ProdectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzihao
 * @create 2020-04-11-18:20
 */
@RestController
@Slf4j
public class MyController {

    @Autowired
    ProdectService prodectService;


    @RequestMapping("/hello")
    public String hello(){
        log.info("123123");
        return "hello world !";
    }

    @RequestMapping("/test")
    public String test() {
        try {
            prodectService.insert2();
        }catch (Exception e){

        }
        return "hello world!";
    }
}
