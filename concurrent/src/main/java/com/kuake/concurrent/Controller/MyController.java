package com.kuake.concurrent.Controller;

import com.kuake.concurrent.service.ProdectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzihao
 * @create 2020-04-11-18:20
 */
@RestController
public class MyController {

    @Autowired
    ProdectService prodectService;


    @RequestMapping("/hello")
    public String hello(){
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
