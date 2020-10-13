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


}
