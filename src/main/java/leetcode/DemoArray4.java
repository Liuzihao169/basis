package leetcode;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author hao
 * @create 2019-07-22 ${TIM}
 * 力扣 求两个数组之间的中位数
 */
public class DemoArray4 {


    @Test
    public void test(){
        int a []= {1,2};
        int b []= {3,4};
        double medianSortedArrays = findMedianSortedArrays(a, b);
        System.out.println(medianSortedArrays);
    }

    public double  findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr [] = new int[nums1.length+nums2.length];
        int n1 = 0;
        int n2 = 0;
        int a = 0;
        while (true){
            if(n1>=nums1.length||n2>=nums2.length) {
                if (n1 >=nums1.length) {
                    for (int i = n2; i < nums2.length; i++) {
                        arr[a++] = nums2[i];
                    }
                } else {
                    for (int i = n1; i < nums1.length; i++) {
                        arr[a++] = nums1[i];
                    }
                }
                break;
            }
            if(nums1[n1]<=nums2[n2]){
                arr[a]=nums1[n1++];
            }else {
                arr[a]=nums2[n2++];
            }
            a++;


        }
        // 判断奇偶
        if(arr.length==(nums1.length+nums2.length)){
            if(arr.length==(nums1.length+nums2.length)){
                if(arr.length%2==0){
                    return ((double) arr[(arr.length/2)-1]+arr[(arr.length/2)])/2;
                }
                return arr[(int)Math.ceil(arr.length/2)];
            }
        }

        return 0;
    }

    @Test
    public void test2(){
        double a= 5d/2;
        System.out.println(a);
    }

}
