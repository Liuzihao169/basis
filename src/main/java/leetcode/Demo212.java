package leetcode;

import datastructure.tree.Tire;
import org.junit.Test;

import java.util.*;

/**
 * @author liuzihao
 * @create 2019/12/5-10:50
 * 力扣单词搜索：字典数字
 */
public class Demo212 {


    @Test
    public void test() {

        char[][] bord = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> words1 = findWords1(bord, words);
        System.out.println(words1);
    }

    public List<String> findWords1(char[][] board, String[] words) {
        List<String> list = new ArrayList<>(words.length);
        for (int i = 0; i < words.length; i++) {
            if (isTarget(board, words[i])) {
                list.add(words[i]);
            }
        }
        return list;
    }

    boolean isTarget(char[][] board, String words) {
        List<int[]> curs = null;
        for (int i = 0; i < words.length(); i++) {
            List<int[]> indexs = getxy(board, words.charAt(i));
            if (indexs.size() == 0) {
                return false;
            }
            if (curs == null) {
                curs = indexs;
                continue;
            }
            boolean flag = false;
            // 进行校验是否连串
            for (int[] index : indexs) {
                for (int[] cur : curs) {
                    if ((Math.abs(cur[0] - index[0]) == 1 && cur[1] - index[1] == 0) || (Math.abs(cur[1] - index[1]) == 1 && cur[0] - index[0] == 0)) {
                        curs = indexs;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    List<int[]> getxy(char[][] board, char c) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (c == board[i][j]) {
                    list.add(new int[]{i, j});
                }
            }
        }
        return list;
    }


    //字典树的使用解题 力扣 DFS深度探索 + 递归 回溯 寻找答案
    //使用visited 当做标记，用于记录是否被访问过。然后使用递归回溯的方法 进行上、下、左、进行DFS
    /**
     *使用DFS+递归的解题情景：
     * 需要遍历，然后遍历过程中 每个节点都要尝试，遍历的时候 进行试探调用、然后寻找出合适的答案
     *1、(设置结果之后、调用链回来的时候  需要 ****还原访问过的路径*****)
     *2、递归的时候进行设置条件出口
     *3、递归的时候要条件判断，收集结果
     */
    @Test
    public void testDemo212DFS(){
        char[][] bord = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> words1 = findWords(bord, words);
        System.out.println(words1);
    }


    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        Tire tire = new Tire();
        // 将内容存入字典树当中
        for(int i = 0 ;i<words.length;i++){
            tire.insert(words[i]);
        }
        boolean [][] visited = new boolean[m][n];
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                // 每一个节点都要进行探测
                dfs(board,visited,tire,"",i,j,set);
            }
        }

        return  new ArrayList<String>(set);
    }

    void dfs(char[][] board, boolean [][] visited, Tire tire,String s ,int i , int j,Set set){

        //1.设置递归条件。没有超越数组边界
        if (i<0||i>=board.length||j<0||j>=board[0].length){
            return;
        }

        if (visited[i][j]) return;
        //3.如果到达终点那么收集结果

        s+= board[i][j];
        //2.如果不是起点 那么就直接返回
        if (!tire.startsWith(s)){
            return;
        }

        if (tire.search(s)){
            set.add(s);
        }
        //设置该节点的访问记录
        visited[i][j] = true ;
        //上下左右全部进行探测进行递归
        dfs(board,visited,tire,s,i+1,j,set);
        dfs(board,visited,tire,s,i-1,j,set);
        dfs(board,visited,tire,s,i,j+1,set);
        dfs(board,visited,tire,s,i,j-1,set);
        //还原访问记录
        visited[i][j] = false;
    }
}
