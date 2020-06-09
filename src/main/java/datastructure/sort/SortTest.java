package datastructure.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void test1(){
        int temp;
        int [] arr= {1,4,5,2,6,9,10};
        for (int i = 0; i <arr.length-1; i++) {
            for (int j = 0; j <arr.length-1-i ; j++) {
                if (arr[j]>arr[j+1]){
                    //交换
                    temp= arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //快速排序
    //比较思想每次比较出一个最小或最大值。放在最前端
    //不稳定
    //时间复杂度O(n^2)
    @Test
    public void test2(){
        int temp;
        int [] arr= {1,4,5,2,6,9,-1};
        for (int i = 0; i < arr.length-1; i++) {
            //假设当前角标代表的数据是最小值
            int min = i;
            //从 i+1——arr.length挑选出最小值然后与 假设的最小值比价
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[min]>arr[j]){
                    min =j;
                }
            }
            //判断 min位置是否是最小的
            if(i!=min){
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
    public void test3(){
        int temp;
        int [] arr= {1,4,5,2,6,9,-1};
        for (int i = 1; i <arr.length; i++) {
                for (int j = i; j >0&&arr[j]<arr[j-1]; j--) {
                    //交换
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1]= temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
