package alg.tooffer;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuzihao
 * @create 2020-11-05-20:37
 * 面试题29: 顺时针打印矩阵
 * 输入一个矩阵、按照从外像里面以顺时针的孙婿打印出每一个数字
 */
public class Demo29 extends DemoBase{


    @Test
    public void test2(){
        int [][] arr = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13}
        };
        Solution_offer29 solution_offer29 = new Solution_offer29();
        solution_offer29.spiralOrder(arr);
    }
    /**
     * 解决思路:
     * 定义上、下、左、右的边界，然后每次执行完成后对应的边界缩小
     */
    @Test
    public void test1(){
        int [][] arr = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int [] up = {0,arr[0].length - 1};
        int [] down = {0,arr[0].length - 1};
        int [] left = {0,arr.length -1};
        int [] right = {0, arr.length -1};
        while (check(up, down, left, right)){
            printUp(right,up,arr);
            left[0] = left[0] + 1;
            right[0]= right[0] + 1;

            printRigth(up,right,arr);
            up[1] = up[1] - 1;
            down[1] = down[1] -1;

            printDown(right, down,arr);
            left[1] = left[1] - 1;
            right[1]= right[1] - 1;

            printLeft(up,left, arr);
            up[0] = up[0] + 1;
            down[0] = down[0] + 1;
        }


    }

    private boolean check(int[] up, int[] down, int[] left, int[] right) {
        return up[0]!=up[1] || down[0]!=down[1] || left[0]!=left[1] || right[0]!=right[1];
    }

    private void printLeft(int[] up, int[] left, int[][] arr) {
        int a = left[1];
        while (a >= left[0]) {
            System.out.println(arr[a][up[0]]);
            a--;
        }
    }

    private void printDown(int[] right, int[] down, int[][] arr) {
        int a = down[1];
        while (a>=down[0]){
            System.out.println(arr[right[1]][a]);
            a--;
        }
    }

    private void printRigth(int[] up, int[] right, int[][] arr) {
        int a  = right[0];
        while (a<=right[1]) {
            System.out.println(arr[a][up[1]]);
            a++;
        }
    }

    private void printUp(int [] right, int[] up,int [][] arr) {
        int a = up[0];
      while (a <= up[1]) {
          System.out.println(arr[right[0]][a]);
          a ++;
      }
    }


}

class Solution_offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null){
            return new int [0];
        }
        int [] target = new int[matrix.length * matrix[0].length];
        int total = matrix.length * matrix[0].length;
        int updownOffset = 0;
        int leftRightOffset = 0;
        // 宽度
        int w = matrix[0].length;
        // 高度
        int h = matrix.length;

        int index = 0;
        while(updownOffset <= matrix.length/2){

            // 上 左到右
            for(int i = leftRightOffset; i < w-leftRightOffset; i++){
                target[index++] = matrix[updownOffset][i];
            }
            if(index>=total-1){
                break;
            }

            // 右 上到下
            for(int i = updownOffset + 1; i < h -updownOffset; i++){
                target[index++] = matrix[i][w-leftRightOffset-1];
            }
            if(index>=total-1){
                break;
            }

            // 下 右到左
            for(int i = w - leftRightOffset-2 ;i>=leftRightOffset; i--){
                target[index++] = matrix[h-updownOffset-1][i];
            }
            if(index>=total-1){
                break;
            }

            // 左 下到上
            for(int i = h - updownOffset -2; i >=1 + updownOffset ;i--){
                target[index++] = matrix[i][leftRightOffset];
            }
            if(index>=total-1){
                break;
            }
            updownOffset++;
            leftRightOffset++;
        }
        return target;
    }
}
