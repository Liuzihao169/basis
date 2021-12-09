package alg.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author liuzihao
 * @create 2021-11-29-08:37
 */
public class Demo36 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};
        Solution36 solution36 = new Solution36();
        System.out.println(solution36.isValidSudoku(board));
    }
}
class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,  HashSet<Character>> rowmap = new HashMap<>(9);
        Map<Integer,  HashSet<Character>> colmap = new HashMap<>(9);
        Map<Integer,  HashSet<Character>> indexmap = new HashMap<>(9);

        for(int i = 0; i < 9 ;i++) {
            HashSet<Character> row = rowmap.computeIfAbsent(i, k -> new HashSet<Character>(9));
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.'){
                    continue;
                }
                HashSet<Character> col = colmap.get(j);
                if(col == null) {
                    col = new HashSet<Character>(9);
                    colmap.put(j, col);
                }
                if(!row.add(board[i][j])){
                    return false;
                }
                if(!col.add(board[i][j])){
                    return false;
                }
                int index = getIndex(i,j);
                HashSet<Character> indeSet = indexmap.get(index);
                if(indeSet == null){
                    indeSet = new HashSet<Character>(9);
                    indexmap.put(index, indeSet);
                }
                if(!indeSet.add(board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    int getIndex(int i , int j){
        return (i/3) * 3 + (j/3 + 1);
    }
}