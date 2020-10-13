package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-10-12-08:27
 * 面试题16：数值的整数次方
 * pow函数(不需要考虑大数问题)
 */
public class Demo16 {

    @Test
    public void test() {
        System.out.println(getResult(8, 2));
        System.out.println(getResult(8, 0));
        System.out.println(getResult(8, -1));
        System.out.println(1.0/8);
    }

    private double getResult(int traget, int n) {
        return n<0 ? 1.0/pow(traget,n < 0 ? -n :n) : pow(traget,n < 0 ? -n :n);
    }

    /**
     * 解题思路：考虑3种情况 负数、0 、正数
     * @param traget
     * @param n
     * @return
     *
     * n为偶数：
     * a^n = a^n/2 * a^n/2
     * n为奇数：
     * a^n = a^n/2 * a^n/2 * a
     *
     * n<0 则取负数最后结果集取负数
     */
    private int pow(int traget, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return traget;
        }
        // 偶数
        if ((n&1) == 0) {
            return pow(traget, n/2) * pow(traget, n/2);
        }else {
        // 奇数
            return pow(traget, n/2) * pow(traget, n/2) * traget;
        }
    }
}
