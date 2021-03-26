package alg.tooffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzihao
 * @create 2021-02-13-19:16
 * 面试题目：
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */
public class Demo49 {
    /**
     *
     * 其核心思想是：每一个丑数必然是由之前的某个丑数与2，3或5的乘积得到的，
     * 这样下一个丑数就用之前的丑数分别乘以2，3，5，找出这三这种最小的并且大于当前最大丑数的值，即为下一个要求的丑数。
     *
     * 核心思想：利用已经存在的 丑数推出 下一个丑数，并进行排序
     */
    @Test
    public void test(){
        int n = 10;
        int nUgly = genAllUglyBefore(n);
        System.out.println(nUgly);
    }

    /**
     * 求第n个丑数
     * @param n
     * @return
     */
    private int genAllUglyBefore(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while (list.size()  < n){
        Integer counti2 = list.get(i2) * 2;
        Integer counti3 = list.get(i3) * 3;
        Integer counti5 = list.get(i5) * 5;

        int min = Math.min(Math.min(counti2, counti3), counti5);

        if (min == counti2) {i2++;};
        if (min == counti3) {i3++;};
        if (min == counti5) {i5++;};
        list.add(min);
        }
        return list.get(list.size() - 1);
    }
}
