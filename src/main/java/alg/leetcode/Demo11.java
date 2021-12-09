package alg.leetcode;

/**
 * @author liuzihao
 * @create 2021-10-18-22:50
 */
public class Demo11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int i = solution11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);

    }
}
class Solution11 {
    /**
     * 解题思路1:暴力破解法
     * max(i-j,min(H[i],H[j]))
     *
     *
     */
    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length - 1; i++){
            for( int j = i+1; j< height.length; j++){
                System.out.println("i:"+ i+"j: "+ j +"minHight"+ Math.min(height[i],height[j]));
                max = Math.max((j-i) * Math.min(height[i],height[j]),max);
            }
        }
        return max;
    }
}
