package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2021-09-22-20:08
 *  第56题
 *  题目： 数组中数字出现的次数
 *  一个整行数组里除两个数字之外，其他数字都出现了两次，
 *  找出这两个只出现一次的数字，要求时间复杂度是o(n) 空间复杂度是o(1)
 *  例如：[2,4,3,6,3,2,5,5]
 */
public class Demo56 extends DemoBase{


    /**
     * 解体思路：
     * 有下面的几个性质
     * 1.任何数和本身异或是0
     * 2.任何数和0异或是本身
     * 3.异或运算满足交换律，即a^b^c=a^c^b
     * 先转化成另外一个题目：
     * 如果 一个整行数组里除一个数字之外，其他数字都出现了两次，
     * 所以数字异或 ，就是得到 那个数据本身
     * 例如：3^4^3^6^4 = 6
     *
     * 只要我们能把 原数组拆分成两个数组，再利用前面的上述方法 就能找出不同的数字了；
     * 如何区分；
     * 1、全部异或 例如得出结果 0101 设第一个为1 为n位
     * 利用原数组 第n位是否为1 分为两个数组
     */
    @Test
    public void test_1(){
        int[] array = new int[]{2,4,3,6,3,2,5,5};
        int [] num1= new int[1];
        int [] num2= new int[1];
        FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        if (array == null || array.length < 2) {
            return;
        }
        int xor = 0;
        /**
         * 全部值异或 得出 目标值的 异或结果
         */
        for (int num : array) {
            xor ^= num;
        }
        int index = 0;
        /**
         * 找到分界线 的index
         */
        while (xor > 0 && (xor & 1) == 0) {
            xor >>= 1;
            index++;
        }


        /**
         * 根据index 是 1/0 进行 分流处理 进行异或 得出目标值
         */
        for (int num : array) {
            if (((num >> index) & 1) > 0) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }


    }
}
