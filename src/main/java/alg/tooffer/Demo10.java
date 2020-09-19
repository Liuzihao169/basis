package alg.tooffer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzihao
 * @create 2020-09-19-17:33
 * 斐波那契数列
 * f(n) = 
 *  f(0) = 0
 *  f(1) = 1
 *  f(n) = f(n-1) + f(n-2) [n > 1]
 *
 */
public class Demo10 {
    @Test
    public void test(){
        System.out.println("斐波那契数列的结果是:"+ fen(5));
        // 使用带有缓存 缓存每次数据
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("使用带有缓存 缓存每次数据:"+ fen(5,map));
        System.out.println("使用动态规划求解:"+ genDp(5));
    }


    /**
     * 递归解决问题的时候会有很多重复的子问题：
     * 例如：
     * f(9) = f(8) + f(7)
     * 那么求f(8)的时候会需要求 f(7) ， f(6)
     * 求f(7)的时候会要求 f(6) f（5） 那么f(6) 这一项目就被重复求值
     * @param n
     * @return
     */
    private int fen(int n ) {
       if (n == 0) return 0;
       if (n == 1) return 1;
       return fen(n - 2 ) + fen(n - 1 );
    }

    /**
     * 使用map缓存数据,每次递归的时候从缓存中获取
     * @param i
     * @param map
     */
    private int fen(int i, Map<Integer, Integer> map) {
        if (i == 0) {
            map.put(i,0);
            return 0;
        }
        if (i == 1) {
            map.put(i, 1);
            return 1;
        }
        if (i > 1) {
             if (null != map.get(i)) {
                 return map.get(i);
             }else {
                 return fen(i - 1) + fen( i - 2 );
             }
        }
        return 0;
    }

    /**
     * 使用动态划分的方式 从低到上求问题
     * dp[i] = dp[ i-1 ] + dp[ i-2 ]
     */
     int  genDp(int n) {
         int [] arr = new int[n];
         arr[0] = 0;
         arr[1] = 1;

         for (int i = 2; i < n; i++) {
             arr[i] = arr[i-1] + arr[i-2];
         }
         return arr[n-1] + arr[n-2];
     }


}
