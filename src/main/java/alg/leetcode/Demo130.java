package alg.leetcode;

/**
 * @author liuzihao
 * @create 2022-01-02-11:31
 */
public class Demo130 {
    public static void main(String[] args) {
        char[][] board = new char[][]
                {{'X','O','X','O','X','O'},
                 {'O','X','O','X','O','X'},
                 {'X','O','X','O','X','O'},
                 {'O','X','O','X','O','X'}}

        ;

        Solution130 solution130 = new Solution130();
        solution130.solve(board);
    }
}
class Solution130 {
    public void solve(char[][] board) {
        if(board.length <=2){
            return;
        }
        char[][] tmp = new char[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++) {
                if(i == 0 || i == board.length -1 || j == 0 || j == board[0].length -1){
                    if(board[i][j] == 'O') {
                        toTarget(i,j,tmp,board);
                    }
                }
            }
        }
        for(int i = 1; i <board.length -1; i++){
            for(int j = 1; j < board[0].length - 1; j++) {
                if(tmp[i][j] != 'i'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void toTarget(int i , int j, char[][] tmp , char[][] board) {
        if(i <0|| j <0 || i >= tmp.length || j>= tmp[0].length){
            return;
        }
        if(board[i][j] == 'O' && tmp[i][j] != 'i') {
            tmp[i][j] = 'i';
            toTarget(i-1,j,tmp,board);
            toTarget(i+1,j,tmp,board);
            toTarget(i,j-1,tmp,board);
            toTarget(i,j+1,tmp,board);
        }
    }
}