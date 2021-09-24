package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2021-09-23-23:14
 * 面试题57
 * 和为s的两个数字
 * 输入一个递增排序的数组和数字，在数组中查找两个字，使得他的和正好为s
 * 如果有多对，随机任意输出一对就可以
 * 输入数字：{1,2,4,7,11,15} 数字15
 * 输出 4 ，11
 */
public class Demo57 extends DemoBase {

    /**
     * 解题思路：
     * 1、俩俩相加，得出目标值 时间复杂度 o(n)
     *
     * 2、定义两个指针 从首 尾开始移动 因为是有序的，所以根据结果 与目标值的大小来进行移动
     */
    @Test
    public void test(){
    int [] arr = new int[]{1,2,4,7,11,15};
    int target = 15;

    int leftValue = 0;
    int rightValue = 0;
    int leftIndex = 0;
    int rightIndex = arr.length -1 ;
    while (true) {
        if (leftIndex == rightIndex) {
            return;
        }
        if (arr[leftIndex] + arr[rightIndex] > target){
            rightIndex = rightIndex  - 1;

        }else if (arr[leftIndex] + arr[rightIndex] < target){
            leftIndex = leftIndex + 1;

        }else if (arr[leftIndex] + arr[rightIndex] == target){
            leftValue = arr[leftIndex];
            rightValue = arr[rightIndex];
            break;
        }
    }
        System.out.println("目标值为:"+ leftValue +" + "+ rightValue);
    }
}
