package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-12-08-18:55
 * 面试题：数组中出现次数超过一半的数字
 * {1,2,3,2,2,2,5,4,2}  输出 2
 */
public class Demo39 extends DemoBase{

    /**
     * 解题思路：
     * 次数出现过一半的数字一定一定是中位数
     * 可以利用快速排序的思想选者标兵
     * 直到获取到n/2的数据
   */
    @Test
    public void test(){
        int [] target =  {1,2,3,2,2,2,5,4,2};
        int index = find4Median(target, 0, target.length-1);
        System.out.println(index);
    }

    private int find4Median(int[] target, int start, int end ) {
        // 1、找出 交换的index
        // 2 index = n/2 返回
        int flagIdx = start;
        // index > n/2 递归左范围
        // index < n/2 递归右循环
        int leftIndex = start;
        int rightIndex = end;
        while (leftIndex !=rightIndex) {
            rightIndex = finLtFlag(leftIndex, rightIndex, target, flagIdx);
            leftIndex = findGtFlag(leftIndex, rightIndex, target, flagIdx);
            if (target[leftIndex] != target[rightIndex]) {
                swapLeftRight(rightIndex, leftIndex, target);
            }
        }

        swapLeftRight(flagIdx, leftIndex, target);
        // 递归左范围
        if (leftIndex > (int)(target.length/2)) {
            return find4Median(target, start, leftIndex - 1);
        }else if (leftIndex < (int)(target.length/2)) {
            return find4Median(target, leftIndex + 1, end);
        }else {
            return leftIndex;
        }
    }

    private void swapLeftRight(int tirght, int leftIndex, int[] target) {
        int temp = target[tirght];
        target[tirght] = target[leftIndex];
        target[leftIndex] = temp;
    }

    /**
     * 比目标值小
     * @param leftIndex
     * @param rightIndex
     * @param target
     * @param flagIdx
     * @return
     */
    private int finLtFlag(int leftIndex, int rightIndex, int[] target, int flagIdx) {
        for (int i = rightIndex; i>=leftIndex; i--) {
            if (target[i] < target[flagIdx]) {
                return i;
            }
        }
        return leftIndex;
    }

    /**
     * 比目标值大
     * @param leftIndex
     * @param rightIndex
     * @param target
     * @param flagIdx
     * @return
     */
    private int findGtFlag(int leftIndex, int rightIndex, int[] target, int flagIdx) {
        for (int i = leftIndex; i <= rightIndex; i++) {
            if (target[i] > target[flagIdx]) {
                return i;
            }
        }
        return rightIndex;
    }
}
