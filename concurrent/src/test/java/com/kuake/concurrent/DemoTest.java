package com.kuake.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liuzihao
 * @create 2020-04-14-21:03
 */
@Slf4j
public class DemoTest {
    @Test
    public void test(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        integers = Collections.unmodifiableList(integers);
        integers.add(1);
        System.out.println(integers);
    }

    @Test
    public void test1(){
        Product.ProductBuilder da = Product.builder().desc("DA");
    }
    // UnsupportedOperationException
    @Test
    public void test2(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        integers.add(1);
    }


    public List<Integer> init(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        return  list;
    }

    @Test
    public void test3(){

        try {
            delete1();
        }catch (Exception e){
            log.info("delete1 方法遍历删除出现异常，异常类型是{}",e.getClass().getSimpleName());
        }
        try {
            delete2();
        }catch (Exception e){
            log.info("delete2 方法遍历删除出现异常，异常类型是{}",e.getClass().getSimpleName());
        }
        try {
            delete3();
        }catch (Exception e){
            log.info("delete3 方法遍历删除出现异常，异常类型是{}",e.getClass().getSimpleName());
        }

    }

    public <T> void  delete1(){
        List<Integer> list = init();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(3)){
                list.remove(i);
            }
        }

        log.info("delete1 方法执行成功");
    }

    public void  delete2(){
        List<Integer> list = init();
        Iterator <Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next.equals(3)) {
                iterator.remove();
            }
        }
        log.info("delete2 方法执行成功");
    }
    public  void  delete3(){
        List<Integer> list = init();
        for (Integer t : list) {
            if (t.equals(3)) {
                list.remove(t);
            }
        }
        log.info("delete3 方法执行成功");
    }

    @Test
    public void test5(){
        Integer i = 1000;
        Integer i2 = 1000;
        System.out.println(i.equals(i2));
    }

    @Test
    public void test6(){
        Stream<String> stream = Stream.of("I", "love", "you", "too");

//        List<String> list = stream.collect(Collectors.toList()); // (1)
//
//     Set<String> set = stream.collect(Collectors.toSet()); // (2)

     Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length)); //

        map.entrySet().forEach(entry -> System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue()));

        Stream<String> stream1 = Stream.of("I", "love", "you", "too");
        // 方法引用
        stream1.forEach(
            System.out::println
        );
    }
}
