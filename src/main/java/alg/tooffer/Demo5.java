package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-09-08-22:38
 * 剑指offer
 * 第5题目：替换空格
 * 例如：my best ==> my20%best
 */
public class Demo5 {
    @Test
    public void test() {
        char[] string = new char[] {'a','b'};
        char[] afer = genRelpace (string);
    }

    private char[] genRelpace(char[] string) {
        // 获取空格的数量
        int count_ = 0;
        for (int i = 0; i < string.length; i++) {
            if ((int)string[i]==32) {
                count_++;
            }
        }
        int afterLength = string.length + 2*count_;
        char [] aterString = new char[afterLength];
        int p1 = string.length -1;
        int p2 = afterLength -1;
        while (p1 != p2) {
            if ((int)string[p1] == 32) {
                // a. 移动位置操作 b.替换空格
                p1--;
                aterString[p2--] = '0';
                aterString[p2--] = '2';
                aterString[p2--] = '%';
            }else {
                aterString[p2] = string[p1];
                p1--;
                p2--;
            }
        }
        return aterString;
    }
}
