package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-09-07-20:53
 * 剑指offer
 * 题目四：二维数组中的查找
 * 每一行 从左到右递增
 * 每一列 从上到下递增
 * int arr [] [] = new int {
 * {1, 2, 8, 9},
 * {2, 4, 9, 12},
 * {4, 7, 10, 13},
 * {6, 8, 11, 15}
 * <p>
 * }
 */
public class Demo4 {

    /**
     * 解题思路从顶角开始剔除数据
     * 例如：目标数是7
     * 右上角9 > 7 去除9 这一列
     * 8 > 7 去除 8 这一列
     * 2 比7 小去除 2这一行
     */
    @Test
    public void test() {
        int arr[][] = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        System.out.println("是否存在目标数字:"+findTarget(19,arr));
        System.out.println("是否存在目标数字:"+findTarget(1,arr));

    }

    private boolean findTarget(int target, int[][] arr) {
        // 列
        int c = arr[1].length - 1;
        // 行
        int r = 0;
        int crr = arr[0][c];
        while (crr != target) {
            if (checkIfIntop(r, c, arr)) {
                return false;
            }
            crr = arr[r][c];
            if (crr > target) {
                c--;
            } else {
                r++;
            }
        }
        return true;
    }

   private boolean checkIfIntop(int r, int c, int [][] arr) {
        return c < 0 || r < 0 ||  c > arr[1].length -1 || r > arr.length - 1;
    }
}
