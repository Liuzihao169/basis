package alg.tooffer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author liuzihao
 * @create 2020-10-12-21:13
 * 面试题17：打印从1到最大的n位
 * 解题思路：考虑溢出问题
 * 利用字符串加法求解
 */
public class Demo17 {
    @Test
    public void test(){
        sysTon(2);
    }
    @Test
    public void test2(){
        char a = '\0';
        System.out.println(a + "123");
    }

    /**
     *
     * @param n
     */
    private void sysTon(int n) {
        if (n<=0) {
            throw new RuntimeException("输入参数不合法");
        }

        char [] chars = new char[n + 2];
        Arrays.fill(chars,'0');
        while (incr(chars)){
            prin(chars);
        }

    }

    /**
     * 加1：
     * 如果当前为10，则当前设置i为10，设置i为0，并且进入下一次循环 i+1 位数字+1
     * @param chars
     * @return
     */
    private boolean incr(char[] chars) {
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[1] == '1') {
                return false;
            }
            int a = (chars[i] - '0') + 1;
            if (a == 10) {
                chars[i] = '0';
               // chars[i -1] = (char)((int)chars[i] + 1);
            }else {
                chars[i] = (char)(a + '0');
                return true;
            }
        }
        return true;
    }

    private void prin(char[] chars) {
        boolean flag = true;
        for (char aChar : chars) {
            if (aChar == '0' && flag) {
                continue;
            }
            flag =false;
            System.out.print(aChar);

        }
        System.out.println();
    }

}
