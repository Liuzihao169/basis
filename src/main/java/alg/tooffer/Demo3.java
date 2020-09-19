package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-09-06-21:16
 * 剑指offer
 * 第3题目：数组中重复的数字
 */
public class Demo3 {

    /**
     * 【会改变数组第的内容】
     * 解题思路：
     * 数组的范围是0-n-1
     * 扫描下标志为i 判断是否等于i
     * 是：扫描下一个数字
     * 否：取出数组中第m个 数字与它比较交换
     */
    @Test
    public void test1() {
        int[] arr = new int[]{1, 2, 4, 1, 3, 2};
        int temp;
        int m;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                m = arr[i];
                if (m == arr[m]) {
                    System.out.println("重复第数字是 : " + m);
                    break;
                } else {
                    temp = arr[m];
                    arr[m] = arr[i];
                    arr[i] = temp;
                }

            }
        }

    }

    /**
     * 【不改变数组的内容】
     */
    @Test
    public void test2(){

    }
}
