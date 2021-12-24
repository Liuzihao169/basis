package alg.leetcode;

import java.util.Arrays;

/**
 * @author liuzihao
 * @create 2021-12-16-20:22
 */
public class Demo31 {
    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        int [] a = new int[]{1,2};
        solution31.nextPermutation(a);
        System.out.println(Arrays.toString(a));
        Solution79 solution79 = new Solution79();
        char [] [] bord = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char [] [] bord1 = new char[][]{{'C','A','A'},{'B','A','A'},{'B','C','D'}};

        String word = "AAB";
        System.out.println(solution79.exist(bord1, word));

    }
}

class Solution31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >=0 ) {
        if (nums[i] < nums[i+1]){
            break;
        }
            i--;
        }
        // i 为较小值
        int j =  nums.length - 1;
        if (i >=0) {
            while (j >= 0 && j > i) {
                if (nums[j] > nums[i]) {
                    break;
                }
                j--;
            }

            swap(i, j, nums);
        }
        resove(i,nums);


    }

    // 交换
    private void swap(int a, int b, int [] nums) {
        if(a ==b){return;}
        int temp = 0;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void resove(int i , int [] nums) {
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right){
            swap(left, right, nums);
            left++;
            right--;

        }
    }
}
class Solution79 {
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
        for(int i =0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    dfs(-1,-1,i,j,board,0,word);
                    if(flag){
                        return flag;
                    }
                }
            }
        }
        return false;
    }

    void dfs(int prei,int prej,int i , int j , char[][] board,int index,String word){
        if(index >= word.length()){
            flag = true;
            return;
        }
        if(flag){
            return;
        }
        if(i <0 || j <0 || i >= board.length || j >= board[0].length){
            return;
        }
        if(i == prei && j == prej){
            return;
        }
        if(board[i][j] == word.charAt(index)){
            char a = board[i][j];
            board[i][j] = '1';
            dfs(i,j,i+1,j,board,index+1,word);
            dfs(i,j,i-1,j,board,index+1,word);
            dfs(i,j,i,j+1,board,index+1,word);
            dfs(i,j,i,j-1,board,index+1,word);
          
        }
    }
}