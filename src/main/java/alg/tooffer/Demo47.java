package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2021-01-03-21:43
 * 礼物的最大价值
 * 题目 在一个m x n 的棋盘的每一格里的礼物，并每次向右活着下移动一格，直到棋盘的右下角，
 * 给一个棋盘，计算最多能拿到多少价值的礼物
 */
public class Demo47 extends DemoBase {
     int [][] gift = new int[][] {
             {1, 10, 13, 8},
             {12, 2, 9, 6},
             {5, 7, 4, 11},
             {3, 7, 16, 5}
     };
    @Test
    public void test(){
        // 定义maxI
        int [][] maxI = new int[gift[0].length][gift.length];
      // maxI[gift.length - 1][gift[0].length-1] = gift[gift.length - 1][gift[0].length-1];

        for (int i = gift.length-1;i>=0;i--){
            for (int j = gift[i].length -1 ; j>=0;j--){
                System.out.println(""+i+""+""+j+"");
                try {
                    maxI[i][j] = Math.max(gift[i][j]+getTarget(i+1,j,maxI), gift[i][j]+getTarget(i, j+1, maxI));
                }catch (Exception ex) {
                    throw new RuntimeException();
                }
            }
        }
        System.out.println(maxI[0][0]);
    }

    /**
     *
     * @param gift
     * @param maxI
     */
    private void initGift(int[][] gift, int[][] maxI) {
        for (int i = 0; i<=gift.length-1; i++) {
            maxI[i][gift[0].length-1] = gift[i][gift[0].length-1];
        }
        // maxI[gift.length-1][i] = gift[gift.length-1][i];

        for (int i = 0; i<=gift[0].length-1; i++) {
            maxI[gift.length-1][i] = gift[gift.length-1][i];
        }
    }

    /**
     * 获得目标值
     * @param i
     * @param j
     * @return
     */
    private int getTarget(int i , int j, int [][] maxiD) {
        if (i<0||i>=maxiD.length || j>= maxiD[0].length||j<0){
            return 0;
        }
        return maxiD[i][j];
    }
}
