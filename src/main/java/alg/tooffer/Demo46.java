package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-12-27-20:54
 * 把数字翻译成数字
 * 0 a
 * 1 b
 * ...
 * 25 z
 * 一个数字有多个翻译
 * 例如：12258 有5种不同分翻译 分别是 bccfi bwfi bczi mcfi mzi
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法
 */
public class Demo46 extends DemoBase {

    /**
     * 解题思路：
     * 利用动态规划的思想，归纳出动态表达
     *
     * dp[i] 表示从第i个字母开始有多少种翻译方法
     * dp[i] = dp[i+1] + g(i,i+1)xf(i+2)
     * g(i,i+1) 如果[0,25]范围为1 否则为0
     */
    @Test
    public void test(){
        int [] a =  {1,2,2,5,8};
        int [] a1 = {1};
        int [] a2 = {1,2};
        System.out.println(getAll(a1));
        System.out.println(getAll(a2));
        System.out.println(getAll(a));


    }



    int getAll(int [] a) {
        if (a.length == 0){
            System.out.println("输入不合法");
            return 0;
        }
        int [] dp = new int[a.length];
        dp[a.length - 1] = 1;
        for (int i = a.length -1; i >=0 ; i--) {
            if (i ==  a.length -1) {
                dp[i] = 1;
            }else {
                int temp1  =0;
                int temp2 =1;
                if (i+1 < a.length) {
                    temp1 = dp[i+1];
                }
                if (i+2 < a.length) {
                    temp2 = dp[i+2];
                }
                dp[i] = temp1 + _g(i,i+1,a) * temp2;
            }
        }
        return dp[0];
    }

    private int _g(int i, int i1, int[] a) {
        if (i1 >= a.length) {
            return 0;
        }
        // 需要大于0 小于25
        if ( Integer.parseInt(a[i]+""+ a[i1]) <= 25) {
            return 1;
        }
        return 0;
    }
}
