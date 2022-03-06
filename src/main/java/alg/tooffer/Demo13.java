package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-10-06-14:02
 * 面试题目13:机器人的运动范围
 * 地上有一个m行，n列的方格，一个机器人从坐标0，0开始运动，
 * 它每次可以从左、右、上、下移动一格但不能进入坐标和列坐标大于k
 * 的格子
 */
public class Demo13 {
    @Test
    public void test(){
        //System.out.println(_genCount(9, 8, 14));
        Solution_offer13 solution_offer13 = new Solution_offer13();
        System.out.println(solution_offer13.movingCount(3, 2, 17));

    }

    private int _genCount(int m, int n, int k) {
    char [][]  flage = new char [m][n];
    return moveCount(0, 0, flage, k);
    }

    private int moveCount(int line, int cloumn, char[][] flage, int k) {
        /**
         * 校验边界合法性
         */
        if (!checkTrue(line, cloumn, flage)) {
            return 0;
        }
        /**
         * 是否被访问过
         */
        if (flage[line][cloumn] != '\0') {
            return 0;
        }
        /**
         * 校验是否大于k
         */
        if (!checkGenK(line, cloumn, k)) {
            flage[line][cloumn] = 'A';
            return 1 + moveCount(line , cloumn + 1, flage, k) +
                       moveCount(line, cloumn - 1, flage, k) +
                       moveCount(line + 1, cloumn, flage, k) +
                       moveCount(line - 1, cloumn, flage, k);
        }else {
            return 0;
        }

    }

    /**
     * 计算是否大于k
     * @param line
     * @param cloumn
     * @param k
     * @return
     */
    private boolean checkGenK(int line, int cloumn, int k) {
        return getCountByindex(line) + getCountByindex(cloumn) > k ;
    }

    private int getCountByindex(int index) {
        String indx = index + "";
        int count = 0;
        for (int i = 0; i < indx.length(); i++) {
            count = count + Integer.parseInt(indx.charAt(i) + "");
        }
        return count;
    }
    /**
     *
     * @param line
     * @param cloumn
     * @param flage
     * @return
     */
    private boolean checkTrue(int line, int cloumn, char[][] flage) {
        int m = flage.length - 1;
        int n = flage[0].length - 1;
        return line >= 0 && line <=m && cloumn >=0 && cloumn <= n;
    }

}

class Solution_offer13 {
    int length = 0;
    int m1 = 0;
    int n1 = 0;
    public int movingCount(int m, int n, int k) {
        m1= m;
        n1 = n;
        int [][] flag = new int[m][n];
        dfs(0,0,k,flag);
        return length;
    }

    private void dfs(int curm, int curn ,int k , int [][] flag){

        // 越界
        if(curm < 0 || curm > m1- 1 || curn <0 || curn > n1 -1){
            return;
        }
        // 不符合规则
        if(getTotal(curm,curn)>k){
            return;
        }
        // 已被访问过
        if(flag[curm][curn] != 1){
            length++;
        }

        // 设标记
        flag[curm][curn] = 1;


        // 访问
        dfs(curm,curn + 1,k,flag);
        dfs(curm,curn - 1,k,flag);
        dfs(curm + 1,curn,k,flag);
        dfs(curm - 1,curn,k,flag);



    }


    // 求当前坐标和值
    private int getTotal(int i,int j ){
        return getOntTotal(i)+getOntTotal(j);
    }
    private int getOntTotal(int a){
        if(a < 10){
            return a;
        }
        String a1 = a +"";

        int a2 = 0;
        for(int i = 0 ; i < a1.length(); i++){
            a2 = a2 + (a1.charAt(i)-'0');
        }
        return a2;
    }
}

