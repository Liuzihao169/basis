package leetcode;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2019/12/8-10:14
 * 动态规划，走迷宫
 */
public class DemoDY1 {

    @Test
    public void test() {
        // 初始化迷宫  1代表有石头的障碍,从最左上角开始走 然后走到最右下方
        int[][] arr = {
                //start
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0} //end
        };
        int[][] opt = new int[arr.length][arr.length];
        /**
         * opt:此节点的最多走法 = 此节点左、下 opt之和
         * opt[i,j] = opt[i,j+1]+opt[i+1,j] 碰到石头（1）。opt[i,j]=0
         */
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[0].length - 1; j >= 0; j--) {
                //如果碰到的是 石头障碍 （数组中的1代表障碍物）
                if (arr[i][j] == 1) {
                    opt[i][j] = 0;
                    continue;
                }
                //初始化 紧邻end的两个方块的opt。他们的可行方案分别只有一种
                if ((i == arr.length - 1 && j == arr.length - 2) || (i == arr.length - 2 && j == arr.length - 1)) {
                    opt[i][j] = 1;
                    continue;
                }
                opt[i][j] = _gen(opt, i, j);
            }
        }

        System.out.println(opt[0][0]);
        //打印迷宫的步数表格

    }

    //根据动态转移方程 自底向下获得opt
    int _gen(int[][] opt, int i, int j) {
        //如果是边缘 设置为0
        return _get(opt, i, j + 1) + _get(opt, i + 1, j);
    }

    //初始化 最左一列 和最下一行的数据时要特殊处理 。因为此时数组会越界
    int _get(int[][] opt, int i, int j) {
        if (i >= opt.length || j >= opt.length) return 0;
        return opt[i][j];
    }
}
