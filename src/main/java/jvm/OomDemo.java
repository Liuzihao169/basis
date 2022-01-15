package jvm;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author liuzihao
 * @create 2021-11-20-21:26
 * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=.
 * -Xmx512M 最大
 * -Xmx100M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./a/c/bbb.hprof
 * -XX:MaxDirectMemorySize=10m
 * -Xmx512M -XX:+HeapDumpOnOutOfMemoryError -XX:MaxDirectMemorySize=10m -XX:HeapDumpPath=./a/c/direct.hprof
 */
public class OomDemo {
    public static void main(String[] args) {
    List<String> list = new ArrayList<>();

        while (true){
            String s = IntStream.rangeClosed(0, 1000).mapToObj(i -> "a").collect(Collectors.joining("")) + UUID.randomUUID();
            list.add(s);
        }
    }
}
