package alg.tooffer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author liuzihao
 * @create 2020-12-23-20:52
 * 面试题45：把数组排成最小都数
 * 题目：输入一个正整数 数组，把数组里所有都数字拼接起来排成一个数，打印能拼接出所有数字中最小都一个，
 * 例如 输入{3,32,321} 最小321 32 3
 */
public class Demo45 extends DemoBase{

    /**
     * 其实就是定义一种新的排序规则 n,m 如果 nm>mn 说明 n < m
     * 再利用排序 从小到大即可
     * 3 32 321
     * 32 3 321
     * 32 321 3
     * 把大大往上冒
     */
    @Test
    public void test(){
        List<String> list = Arrays.asList("3", "32", "321");
        list.sort((s1,s2)->{
            String a = s1 + s2;
            String b = s2 + s1;
            return a.compareTo(b);
        });
        System.out.println(list);
    }
}
