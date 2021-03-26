package alg.tooffer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzihao
 * @create 2020-12-09-20:51
 * 面试题最小的K个数字
 * 题目：输入n个整数，找到其中最小的K个数字，输入4、5、1、6、2、7、3、8
 * 输出：最小的K个数字 1、2、3、4、
 */
public class Demo40 extends DemoBase {

    /**
     * 解题思路：利用一种特殊的数据结构 大顶堆 或者小顶堆完成
     * 时间复杂度 (log n K) n：为数组的大小
     */
    @Test
    public void test(){
        Map<String,Object> map  = new HashMap<>();
        map.put("123",1);
        int a = (int) map.get("123");
        System.out.println(a);
    }
}
