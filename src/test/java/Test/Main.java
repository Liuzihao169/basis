package Test;

import java.io.FileNotFoundException;

/**
 * @author liuzihao
 * @create 2021-04-16-14:21
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("执行结果:" + getValue());
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

