package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-12-19-10:20
 * 面试题44：数字序列中的某一位数字
 * 题目：数字以0123456789101112131415...格式序列化成一个字符串中，
 * 在这个序列中 第五位是 5 ，第13位是1 第19位是4
 */
public class Demo44 extends DemoBase {
    /**
     * 利用分组的思想：
     * 0 - 9    9 位
     * 10 - 99  180位
     * 100 - 999 2700 位
     * 1000 - 9999 36000
     * 3 x n + 3x 10^(n-1)
     *
     * 从 n 等于1 开始往后找，找到正确的区间
     */
    @Test
    public void test(){
        System.out.println(getNindex(19));

    }

    private String getNindex(int target) {

        int n = 1;
        int remainCount = target;
        while (true) {
            int count = getbeforencount(n);
            if (target > count) {
                remainCount = target - count;
                n++;
            }else {
                if (target < 10) {
                    return target+"";
                }
                // 找到区间
                int start = (int)Math.pow(10,n-1) - 1;


                int c  = (remainCount)/n;
                int moll = (remainCount) % n;
                if (moll != 0) {
                    c = c+1;
                }
                // 定位到数字
                start = start + c;
                if (moll == 0) {
                    return String.valueOf(start).charAt((start+"").length()-1) + "";
                }
                return String.valueOf(start).charAt(moll) + "";
            }

        }
    }

    /**
     * 获取
     * @param nz
     * @return
     * 3 x n + 3x 10^(n-1)
     */
    private int getbeforencount(int n) {
        if (n == 1) {
            return 10;
        }
        return (int)(3*n *3 * Math.pow(10,n-1));
    }
}
