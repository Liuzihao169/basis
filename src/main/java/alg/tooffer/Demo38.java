package alg.tooffer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author liuzihao
 * @create 2020-12-02-22:36
 * 面试题38：字符串的排序
 * 题目：输入一个字符串、打印出该字符串中索引的排列顺序；
 * abc打印a b c所有字符串 abc acb bca cab cba
 */
public class Demo38 extends DemoBase {
    /**
     * 解题思路：
     * 将字符串分为两个部分 第一个字符 和 后面第部分
     * 进行输出，后半部分用同样的方式进行递归
     *
     *
     * 递归解题：
     * 找到共同的循环体
     * 1、递归体
     * 2、参数
     * 3、返回条件
     */
    @Test
    public void test(){

        char string [] = new char[]{'a','b','c'};

        printAllArrangement(string,0);
    }

    /**
     *
     * @param string
     * @param startIdx
     */
    private void printAllArrangement(char[] string, int startIdx) {
        if (startIdx + 1 >= string.length) {
            System.out.println(Arrays.toString(string));
            return;
        }
        char temp = '\0';
        for (int i = startIdx + 1; i<= string.length - 1; i++) {
            // 1、输出
            System.out.println(Arrays.toString(string));
            // 2、交换
            temp = string[startIdx];
            string[startIdx] = string[i];
            string[i] = temp;

            // 3、递归
            printAllArrangement(string, i);

            // 4、还原数据
            temp = string[startIdx];
            string[startIdx] = string[i];
            string[i] = temp;
        }
    }
}
