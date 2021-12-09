package alg.leetcode;

import java.util.Arrays;

/**
 * @author liuzihao
 * @create 2021-11-10-20:47
 */
public class Demo59 {
    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
        int[][] ints = solution59.generateMatrix(9);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }

    }

}
class Solution59 {
    public int[][] generateMatrix(int n) {
        int [][] martrix = new int[n][n];
        int left = 0;
        int top = 0;
        int down = n ;
        int right = n ;
        int count = n * n ;
        int c = 0;
        while (c < count&& left <= right && top <= down) {

            // 上 右 处理
            if(left <= right && top <= down) {
                for(int i = left; i < right; i++){
                    martrix[top][i] = ++c;
                }
                for(int i = top + 1 ; i < down; i++){
                    martrix[i][right - 1] = ++c;
                }
            }

            // 下 左 处理 边界防止重复
            if(left < right && top < down){
                for(int i = right - 1 - 1; i >=left; i-- ){
                    martrix[down - 1][i] = ++c;
                }
                for(int i = down - 1 - 1; i > top ; i--) {
                    martrix[i][left] = ++c;
                }
            }
            left++;
            right--;
            top++;
            down--;
        }
        return martrix;
    }
}
