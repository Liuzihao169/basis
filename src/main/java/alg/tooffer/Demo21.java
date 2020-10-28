package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-10-23-09:51
 * 面试题21:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变.
 * 数组解决：采用两个标记 a,b
 */
public class Demo21 extends DemoBase{

    /**
     * 解题思路:
     * 从当前节点开始遍历找奇数，找到位置i 为奇数时，然后判断 i-1 是否为偶数，如果是 交换，然后继续往
     * 数组左边判断
     */
    @Test
    public void test(){
    int [] arr = new int []{1,2,3,4,5,6};
    int [] arr1 = new int []{1,4,3,5,7,2};

        // 遍历交换
    traverse(arr);
    traverse(arr1);

    printArr(arr);
    printArr(arr1);



    }

    private void traverse(int [] arr) {
        if (null == arr) {
            throw new RuntimeException("");
        }
        for (int i = 0; i<= arr.length -1; i++) {
            /**
             * 判断奇数，然后递归交换
             */
           if ((arr[i] & 1) ==1) {
               exchangeNumber(i, i-1, arr);
           }
        }
    }
    /**
     *
     * @param cur 当前奇数位置
     * @param pre 前一个位置
     * @param arr
     */
    private void exchangeNumber(int cur, int pre, int[] arr) {
        if (pre < 0) {
            return;
        }
        /**
         * 偶数
         */
        if ((arr[pre] & 1) ==0) {
            // 交换
            int temp;
            temp = arr[cur];
            arr[cur] = arr[pre];
            arr[pre] = temp;
            exchangeNumber(cur - 1, pre - 1, arr);
        }

    }
}

