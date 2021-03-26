package datastructure.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hao
 * @create 2019-08-04 ${TIM}
 */
public class SortTest {

    //冒泡排序
    //比较思想 没两个两个相比比较 交大的往上移动 冒泡
    //是一种稳定的排序算法 比较n-1次  比较排序好的前一个
    //时间复杂度 O（n^2）
    @Test
    public void test1() {
        int temp;
        int[] arr = {1, 4, 5, 2, 6, 9, 10};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //交换
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //改进的选择排序
    //比较思想每次比较出一个最小或最大值。放在最前端
    //不稳定
    //时间复杂度O(n^2)
    @Test
    public void test2() {
        int temp;
        int[] arr = {1, 4, 5, 2, 6, 9, -1};
        for (int i = 0; i < arr.length - 1; i++) {
            //假设当前角标代表的数据是最小值
            int min = i;
            //从 i+1——arr.length挑选出最小值然后与 假设的最小值比价
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            //判断 min位置是否是最小的
            if (i != min) {
                //当前i不是最小值
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //是一种稳定的排序算法
    //插入排序
    //时间复杂度O(n^2)
    //思路：每次插入的时候寻找到合适的位置，然后交换 类似于冒泡
    //第一个元素默认充当基准。
    @Test
    public void test3() {
        int temp;
        int[] arr = {1, 4, 5, 2, 6, 9, -1};
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                //交换
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序 不稳定 选出小的（从小到大）
     */
    @Test
    public void test4() {
        int temp;
        int[] arr = {8, 6, 5, 4, 1, 10, 3};
        int min;
        //8,6,5,4,1,10,3
        //第一次 从 8 [6,5,4,1,10,3]  进行循环只要比第一位小 那么就进行交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 改良选择排序
     */
    @Test
    public void test5() {
        int[] arr = {1, 2, 7, 9, 3, 4, 5};
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            //假定最小的角标
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //  获得小的元素的脚标
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (arr[i] > arr[minIndex]) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            // else 否则 minindex就是最小位置
        }

        System.out.println(Arrays.toString(arr));
    }


    /**
     * 快速排序 nlogn
     * 快速排序的算法关键在于选择一个标兵，然后将比该数字大的移到右边
     * 比该数字小的移到左边
     * 5 2 3 7 9 3 4 12
     * |             ｜
     * i             j
     * i向右边移动找比标兵小的数
     * j向左找比标兵大的数
     * i\j 交换
     *
     * 当i=j （位置相同时）
     * 与目标位置进行交换。
     * 剩下的数组分两边再次重复上述比较
     *
     * 注意：(标兵在哪边往哪边靠拢)
     * a.先移动左边的标兵
     * b.当未找到时候，一致往下找，直到最顶端
     *
     * 编写之前可以先 自己画出比较流程，需要考虑极端情况
     */
    @Test
    public void test06() {
        int[] arr = {1,3,6,2};

        genFirstArr(arr, 0, arr.length -1 );
        System.out.println("快速排序后的结果"+Arrays.toString(arr));
    }

    @Test
    public void test07(){
        Integer a = null;
        doing(a);
    }
   void doing(int a) {
        System.out.println(a);
    }
    private void genFirstArr(int[] arr, int start, int end) {
        // 递归出口 如果只剩一个数字的时候返回
        if (start >= end) {
            return;
        }
        // 1、选标兵（默认选择第一个）
        int flag = arr[start];
        // 2、i,j 移动位置比较
        int leftInx = start;
        int rightInx = end;
        while (leftInx != rightInx) {
            // 移动到相同位置时候 一直找
            rightInx = findMin4Flag(arr, leftInx, rightInx, flag);
            leftInx = findMax4Flag(arr, leftInx, rightInx, flag);
            if (arr[leftInx] != arr[rightInx]) {
                swap(arr,leftInx ,rightInx);
            }
        }
        // 交换目标
        swap(arr, start, leftInx);
        // 3、左右两个数组进行递归排序
        genFirstArr(arr, start, leftInx - 1);
        genFirstArr(arr, leftInx + 1, end);
    }

    /**
     * 找到比目标小
     *
     * @param arr
     * @param leftInx
     * @param rightInx
     * @param flag
     * @return
     */
    private int findMin4Flag(int[] arr, int leftInx, int rightInx, int flag) {
        for (int i = rightInx; i >=leftInx; i--) {
            if (arr[i] < flag) {
                return i;
            }
        }
        return leftInx;
    }

    /**
     * 找到比目标大
     *
     * @param arr
     * @param leftInx
     */
    private int findMax4Flag(int[] arr, int leftInx, int rightInx, int flag) {
        for (int i = leftInx; i <=rightInx; i++) {
            if (arr[i] > flag) {
                return i;
            }
        }
        return rightInx;
    }


    private void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
