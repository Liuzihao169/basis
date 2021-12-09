package alg.leetcode;

/**
 * @author liuzihao
 * @create 2021-11-20-20:53
 */
public class Demo73 {
    public static void main(String[] args) {
        Solution73 solution73 = new Solution73();
        solution73.setZeroes(new int[][]{

                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        });

    }
}

/**
 * 解题思路：利用数组的
 *第一行，代表对应列是否有0
 *第一列，代表对应行是否有0
 * 需要用标记代表原始 第一行 和第一列是否 有0 需要两个额外的标志
 * */
class Solution73 {
    public void setZeroes(int[][] matrix) {
        boolean rowFlag = false;
        boolean colFlag = false;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    if(i == 0 ){
                        rowFlag = true;
                        // continue;
                    }
                    if(j==0){
                        colFlag = true;
                        // continue;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                for(int j = 1; j < matrix.length; j++){
                    matrix[j][i] = 0;
                }

            }
        }

        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < matrix[0].length; j++){
                    matrix[i][j] =0;
                }
            }
        }

        if(rowFlag){
            for(int i =0; i < matrix[0].length; i++){
                matrix[0][i] =0;
            }
        }
        if(colFlag){
            for(int j = 0; j < matrix.length;j++){
                matrix[j][0] =0;
            }
        }

    }
}
