package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-09-23-22:12
 * 面试题11: 旋转数组的最小数字，
 * 题目：把一个数组最开始的若干的元素版到数组到末尾，我们称之为数组的旋转。
 * [3,4,5,1,2] 为[1,2,3,4,5]的一个旋转，求改数组中的最小数字
 * 思路：利用二分法，
 */

public class Demo11 {
    /**
     * 三种情况：
     * 1.正常情况 【3，4，5，1，2】
     * 2.初始数组已经是排序状态【1，2，3，4，5】
     * 3.顺序同元素数组 【1，0，1，1，1】
     */
    @Test
    public void test(){
        int[] arr = new int[]{3, 4, 5, 1, 2};
        System.out.println(getMin(arr));
        int[] arr1 = new int[]{1, 3, 3, 4, 5};
        System.out.println(getMin(arr1));
        int [] arr2 = new int[]{1,0,1,1,1};
        System.out.println(getMin(arr2));
    }

    int getMin(int [] arr) {
        if (arr.length == 0) {
            throw new RuntimeException("数组不合法");
        }
        if (arr.length == 1) {
            return arr[0];
        }
        // 第一种情况
        if (arr[0] < arr[arr.length - 1]) {
            return arr[0];
        }
        int startIdx = 0;
        int endIdx = arr.length - 1;
        // 第二种情况
        int moveIndex = (startIdx + endIdx) / 2;
        if (arr[startIdx] == arr[endIdx] && arr[startIdx] == arr[moveIndex]) {
            return orderSearch(arr);
        }
        // 第三种情况
        while (endIdx -  startIdx != 1 ) {
            if (arr[(startIdx + endIdx)/2] > startIdx) {
                startIdx = (startIdx + endIdx)/2;
            }else {
                endIdx = (startIdx + endIdx)/2;
            }
        }
        return arr[endIdx];
    }

    /**
     * 遍历查找最小的
     * @param arr
     * @return
     */
    private int orderSearch(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
