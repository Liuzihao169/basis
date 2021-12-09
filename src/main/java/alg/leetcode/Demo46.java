package alg.leetcode;

import java.util.Arrays;

/**
 * @author liuzihao
 * @create 2021-11-06-19:12
 */
public class Demo46 {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int [][] a = new int [][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        solution46.rotate(a);
        Arrays.toString(a);
    }
}
class Solution46 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 由外圈到内圈移动 每次移动 2 相当于于需要移动 2/n 层
        // n = 3  移动一层
        // n = 4 移动二层
        // 开始位置
        int start = 0;
        // 结束位置
        int end = matrix.length - 1;
        int times = 0;
        while(n/2 != 0){
            /**
             * 开始旋转移动
             * 1,2,3
             4,5,6
             7,8,9
             先暂存 3的位置
             a. 将 3的位置用临时变量保存 tmp
             b. 1 ->3
             c. 7 -> 1
             d. 9-> 7
             e. tmp - > 9
             * */
            for(int i = start, j= end - times; i < matrix.length - times - 1  && j >0 ; i++,j--) {
                //把容器最后一列数据，存放在临时变量b中
                int tmp = matrix[i][end - times];


                //把第一行的数据，赋值给，最后一列
                matrix[i][end - times ] = matrix[start][i];

                //把第一列的数据，赋值给，第一行
                matrix[start][i] =  matrix[j][start];

                //把最后一行的数据，赋值给，第一列
                matrix[j][start] = matrix[end - times][j];

                //把tmp的数据（之前最后列的数据），赋值给，最后一行
                matrix[end - times][j] = tmp;
            }
            if(n/2 != 0) {
                n = n - 2;
                start = start + 1;
                times = times +1;
            }
        }
    }
}