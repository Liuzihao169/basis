package alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzihao
 * @create 2021-11-09-22:39
 */
public class Demo54 {
    public static void main(String[] args) {
    int [][] a = new int [][]{{1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}};
        Solution54 solution54 = new Solution54();
        System.out.println(solution54.spiralOrder(a));
        //System.out.println(Arrays.toString(a));
    }
}

class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        int offset = 0;
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 1){
            for(int i = 0; i < n; i++){
                list.add(matrix[0][i]);
            }
            return list;
        }
        if(n == 1) {
            for(int i = 0; i < m; i++){
                list.add(matrix[i][0]);
            }
            return list;
        }
        int all = m;
        if(matrix[0].length == 2){
            all =2;
        }
        while(all>0) {

            if(m - 2*offset == 1){
                for(int i = offset; i < n - offset ; i++) {
                    list.add(matrix[offset][i]);
                }
                break;
            }
            if(n - 2*offset == 1){
                for(int i = offset; i < m - offset; i++){
                    list.add(matrix[i][n - offset - 1]);
                }
                break;
            }
            // [左,右]
            for(int i = offset; i < n - offset ; i++) {
                list.add(matrix[offset][i]);
            }

            // (右,下)
            //
            for(int i = offset + 1; i < m - offset - 1; i++){
                list.add(matrix[i][n - offset - 1]);
            }


            // [右，左]
            for(int i = n - offset - 1; i >=offset; i--){
                list.add(matrix[m - offset - 1][i]);
            }
            //(左，上)
            for(int i = m - offset - 2; i > offset; i--){
                list.add(matrix[i][offset]);
            }
            all = all - 2;
            offset++;
        }
        return list;
    }
}
