package alg.tooffer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author liuzihao
 * @create 2021-01-08-20:44
 * 面试题48：
 * 最长不含重复字符串
 * 题目：请重字符串中找出一个最长不包含重复字符串， 计算该最长子字符串的长度，假设字符串中只包含a~z
 * 例如： arabacacfr 中最长的不含重复的字符串是acfr
 */
public class Demo48 {

    /**
     * 定义 f(i):表示 以i 角标结尾的最长无重复字符串
     *
     * f(i) = f(i-1) + test(i);
     *
     * 如果data[i]没有出现在 [0,i-1]中  test(i) = 1
     * 否者
     * a. newIndex[i] - oldIndex[j] <= f(i-1)  test(i) = 0
     * b.  newIndex[i] - oldIndex[j] > f(i-1)  test(i) = 1
     */
    @Test
    public void test(){
        String str = "arabacacfr";
        // 每个字母定义一个位置用来保存是否出现过
        int [] index = new int[26];
        // 初始化角标位置 用来快速校验是否出现过
        Arrays.fill(index, -1);
        index[str.charAt(0) - 'a'] = 0;
        int preF = 1;
        int max = 0;
        for (int i = 1; i<= str.length()-1; i++) {
            int oldIdx = index[str.charAt(i)-'a'];
            if (oldIdx<0 || i-oldIdx >preF) {
                ++preF;
            }else {
                preF = i-oldIdx;
            }
            index[str.charAt(i)-'a'] = i;
            // 临时最大值
            max = preF > max? preF:max;
        }
        System.out.println(str+"最大无重复子序列为：" + max);
    }

    /**
     * 用来验证是否能够递增 相当于test函数
     * @param i
     * @param index
     * @return
     */
    private int testIndex(int i, int[] index, String str, int preF) {
        int oldIdx = index[str.charAt(i)-'a'];
        // 设置位置
        index[str.charAt(i)-'a'] = i;
        // 之前没有出现过
        if (-1 == oldIdx) {
            return 1;
        }
        return i - oldIdx > preF? 1:0;
    }
}
