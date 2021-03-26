package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2021-02-26-08:20
 * 在排序数组中查找数字
 * 题目：数字在排序数组中出现的次数
 * 统一几个数字在排序数组中出现的次数，例如，输入排序数组{1,2,3,3,3,4,5} 和数字3，由于3在这个数组中出现了4次，因此输出4
 */
public class Demo53 extends DemoBase {
    /**
     * 解题思路：
     * 因为已经是排序数组，关键在于定位第一个与最后一个目标值
     * 对二分查找发进行改进，前半段对二分查找法找到第一个；后半段对二分查找法找到最后一个
     */
    @Test
    public void test(){
        int target = 3;
        int [] arr = {1,2,3,3,3,4,5};


        int first = findFirst(arr, target, 0, arr.length-1);
        int end = findEnd(arr, target, 0, arr.length-1);
        if (first != -1 && end != -1) {
            System.out.println(end - first + 1);
        }
    }

    /**
     * 递归找最后一个
     * @param arr
     * @param target
     * @param start
     * @param end
     * @return
     */
    private int findEnd(int[] arr, int target, int start, int end) {
        if (start>end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int midValue = arr[mid];
        if (target == midValue) {
            if (mid ==arr.length-1 || midValue != arr[mid +1]) {
                return mid;
            }else {
                start = mid + 1;
            }
        }else {
            if (midValue < target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return findEnd(arr, target, start, end);
    }

    /**
     /**
     * 如果中间值比 目标值小 目标值在右边
     *
     * 如果中间值比 目标值大 目标值在左边
     *
     * 如果中间值 = 目标值
     * 然后判断是否是 第一个；
     * 考虑极端条件 当前值就是第一个；
     */
    private int findFirst(int[] arr, int target, int start, int end) {
        if (start>end) {
            return -1;
        }
        int mid = (start + end) / 2;

        int midValue = arr[mid];
        if (midValue == target) {
            if (mid == 0 || (arr[mid -1] != target)) {
                return mid;
            }else {
            end = mid - 1;
            }
        }else{
            if (midValue < target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return findFirst(arr, target, start, end);
    }

}
