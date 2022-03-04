package alg.tooffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzihao
 * @create 2020-09-29-21:43
 * 面试题12：矩阵中的路径
 * 一个矩阵
 * a,b,t,g
 * c,f,c,s
 * j,d,e,h
 * 判断矩阵中是否包含字符串bfce的路径
 */
public class Demo12 {

    char[][] str = new char[][]{
            {'a','b','t','g'},
            {'c','f','c','s'},
            {'j','d','e','h'} };

    /**
     * 解题思路：
     * 遍历回溯、设置falge
     */
    @Test
    public void test(){
    String target = "bfce";
    char [][] flag = new char[str.length ][str[0].length];
        System.out.println("taeget:" +target+"\t" + _cyc(str, target, flag, new ArrayList<Character>()));
    }

    boolean _cyc(char[][] source, String target, char [][] flag, List<Character> list) {
        for (int i = 0; i < str.length; i++) {
            for (int i1 = 0; i1 < str[i].length; i1++) {
                if (_findString(source, i, i1, target, flag, list )) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean _findString(char[][] source, int i,int j,String target, char [][] flag, List<Character> list){
        /**
         * 出口条件
         * 1：已经被访问过
         * 2：已经找到了目标string
         * 3: i,j的合法性
         */
        if (!checkIandJ(i, j, source)) {
            return false;
        }
        if ('\0' != flag[i][j]) {
            return false;
        }
        if (list.size() == target.length()) {
            return true;
        }
        // 找到目标值
        if (source[i][j] == target.charAt(list.size())) {
            flag[i][j] = '1';
            list.add(source[i][j]);
            // 左 右 下
            if (_findString(source,i,j-1,target,flag,list)
                    || _findString(source,i,j+1,target,flag,list)
                    || _findString(source,i+1,j,target,flag,list)) {
                return true;
            }else {
                flag[i][j] = '\0';
                list.remove(list.size()-1);
                return false;
            }
            //下
            //右
        }
        return false;
    }

    private boolean checkIandJ(int i, int j, char[][] source) {
        return i >= 0 && i<= source.length -1 && j >=0 && j<= source[1].length -1 ;
    }


    @Test
    public void test12(){
        Solution_0ffer12 solution_0ffer12 = new Solution_0ffer12();
        char[][] board = new char[][]{{'a'}};
        String word = "a";
        solution_0ffer12.exist(board, word);
    }

}





class Solution_0ffer12 {
    boolean find = false;
    public boolean exist(char[][] board, String word) {

        if(word == null || word.length()==0){
            return false;
        }
        if(board == null){
            return false;
        }
        if(board.length*board[0].length < word.length()){
            return false;
        }
        // 访问标记
        int [][] falge = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j< board[0].length; j++){
                if(find){
                    return true;
                }
                // 查找筛选
                doFind(i,j,board,word,0,falge);
            }
        }
        return false;
    }

    // 回溯查找
    public void doFind(int i , int j, char[][] board, String word, int curIndex, int [][] falge) {
        if(curIndex == word.length()){
            find = true;
            return;
        }

        if(find) {return;}

        // 不合法
        if(i<0||i>=board.length || j<0|| j>=board[0].length){
            return;
        }
        // 已经访问过
        if(falge[i][j] == 1){
            return;
        }
        if(word.charAt(curIndex) != board[i][j]) {
            return;
        }
        // 标记设定
        falge[i][j] = 1;
        doFind(i+1,j,board,word,curIndex+1,falge);
        doFind(i-1,j,board,word,curIndex+1,falge);
        doFind(i,j+1,board,word,curIndex+1,falge);
        doFind(i,j-1,board,word,curIndex+1,falge);
        // 复原
        falge[i][j] = 0;
    }
}