package jvm;

import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuzihao
 * @create 2022-01-25-12:26
 * 操作指令
 */
public class OperaInstruc {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println(atomicInteger.get());
    }

    private static int getValue() {
        int num = 1;
        try {
            return num;
        } finally {
            num++;
        }
    }
}
