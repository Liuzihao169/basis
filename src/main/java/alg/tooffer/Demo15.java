package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-10-08-10:30
 * 二进制中1的个数
 */
public class Demo15 {

    /**
     * >>>:以零填充
     * >>:以符号位填充
     *
     * 前提：在计算机中二进制是以补码存在的。 正数的 原码 = 反码 = 补码
     *
     * 解法一：getCountForOne1
     * n & 1
     * n >> 1
     * 每次都比较最后一位
     * 问题：如果是负数的话会出现死循环
     *
     * 解法二:getCountForOne2
     * 利用 比较位flag 每次向左移动
     * 能够处理负数
     *
     * 解方三：bitCount
     * 利用 n & n-1 每次都会将n最左边的1处理为0
     * 经验：把一个整数减去1之后再和原来的整数做与运算，得到到结果相当于把整数到二进制最右边到1变为0，
     * 许多类似到方法都可以用这种思路解决
     */
    @Test
    public void test(){
        Thread.currentThread().setName("123123123");
        System.out.println(5+"中1的个数为" + getCountForOne1(9) + "\n" + Integer.toBinaryString(9));
        System.out.println(-5+"中1的个数为" + getCountForOne2(-5) + "\n" + Integer.toBinaryString(-5));
        System.out.println(-5+"中1的个数为" + bitCount(-5) + "\n" + Integer.toBinaryString(-5));

    }
    int getCountForOne1(int n) {
        int count = 0;
        while (n != 0){
            if ((n&1) == 1){
                count++;
            }
            n = n >>1;

        }
        return count;
    }

    int getCountForOne2(int n) {
        int count = 0;
        int flag = 1;
        while (flag !=0) {
            if ((flag & n) != 0){
                count ++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static int bitCount(int n){
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    @Test
    public void test2(){
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(4));
        System.out.println(4&5);

    }
}
