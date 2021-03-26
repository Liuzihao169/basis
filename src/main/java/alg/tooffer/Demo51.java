package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2021-02-22-21:04
 * 面试题51：数组中的逆序对
 * 在数组中对两个数字，如果前面一个数字大于后面对数字，则两个数字组成一个逆序对（必须是前面对数字 > 后面的数字）
 * {7, 5, 6, 4} ==>(7,5) \ (7,4) \(6,4) \(5,4);
 * 归并排序 O(nlogn)
 */
public class Demo51 {

    int [] copy = new int [4];

    /**
     * 解题思路：
     * 利用归并排序对方法，分而治之对方法 找到排序数组，然后找逆序对
     *
     * 关键是前面的数组 > 后面的数组
     * 利用排序的过程中，进行判断 逆序对的个数
     *
     * 每次移动指针的时候 都需要落地一个排序组合
     */
    @Test
    public void test(){
        int [] arr = {7, 6, 5, 4};
        int cout = getReverseCount(arr, 0, arr.length - 1);
    }

    /**
     *  根据两段数组 得出一段排序数组合
     * @param arr 源数据
     * @param start 开始index
     * @param end 结束index
     * @return
     */
    private int getReverseCount(int[] arr, int start, int end) {
        if (start == end) {
            // 进行赋职
            copy[start] = arr[start];
            return 0;
        }

        int length = (end - start) / 2;
        int leftCount = getReverseCount(arr, start, start + length);
        int rightCount = getReverseCount(arr, start + length + 1 , end);
        // 当前的逆序对
        int count  = 0;

        int p1Index = start + length;
        int p2Index = end;
        int p3CopyIndex = end;

        /**
         * 关键根据start 和length  定位到中间的index
         */
        while (p1Index >= start && p2Index >= start + length + 1) {

        }
        return 0;
    }
}
