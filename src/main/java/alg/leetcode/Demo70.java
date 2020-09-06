package alg.leetcode;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2019/12/9-18:26
 * 力扣70 爬楼梯 使用动态划分 或者 回溯的方法
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶.
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Demo70 {
    // 动态表达式 f(n) = f(n-1) + f(n-2);
    //我们可以推出  f(1) = 1  只能跳一步
    // f(2) = 2 可以1,1 或者 2 两种跳法

    @Test
    public void test(){
        System.out.println(genTime(12));
    }
    // 当n 等于45时  超出时间
   int  genTime(int n){
        if (n==1||n==2) return n;
        return genTime(n-2)+genTime(n-1);
   }

   @Test
    public void test01(){
       System.out.println("次数是:"+_gen(45));
    }
    int _gen(int n){
        int [] f = new int[n];
        f[0] = 1;
        f[1] = 2;
        for(int i = 2;i<n;i++){
            f[i] = f[i-1] + f[i-2];
        }

        return f[n-1];
    }

    @Test
    public void test02(){
        System.out.println("次数"+_gen2(4));
    }

    int _gen2(int n ){
        if (n<=2) return n;
        int start = 3;
        int temp1 = 1;
        int temp2 = 2;
        int target = 0;
        while (start<=n){
            target = temp1 +temp2;
            temp1 = temp2;
            temp2 = target;
            start++;
        }
        return  target;
    }
}
