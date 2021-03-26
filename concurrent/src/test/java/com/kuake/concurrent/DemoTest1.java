package com.kuake.concurrent;

import cn.hutool.core.util.ZipUtil;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;

/**
 * @author liuzihao
 * @create 2020-04-28-20:10
 */
@Slf4j
public class DemoTest1 {
    @Test
    public void test(){

   log.debug("bebug");
   log.error("error");
   log.info("info");
   log.trace("trace");
   log.warn("warn");

    }

    @Test
    public void test2(){
        //         ZipUtil.zip("/Users/liuzihao/Downloads/20210113","123.zip");
        ZipUtil.zip("/Users/liuzihao/Downloads/1212","/Users/liuzihao/Downloads/1212.zip");
        BigDecimal bigDecimal = new BigDecimal("1");
        //doAdd(bigDecimal);
        System.out.println(bigDecimal);
    }
@Test
    public void doAdd(){
        String a  ="";
    String[] split = a.split(",");
    System.out.println(split);
}

}
