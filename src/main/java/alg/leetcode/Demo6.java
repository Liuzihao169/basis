package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzihao
 * @create 2022-02-08-19:17
 */
public class Demo6 {
    public static void main(String[] args) {

    }
}

/***
 * 解题思路：
 * 纵向转横处理
 * 因为已有字符串已经是N的数据结构
 * 那么可以通过转 横向字符串
 *
 * N   C
 * Z j k
 * L   O
 * 转换为:
 * NC
 * ZJK
 * LO
 * 最终结果：NC + ZJK + LO= NCZJKLO
 * */
class Solution6 {
    public String convert(String s, int numRows) {
        if(numRows <=1)return s;
        List<StringBuilder> list = new ArrayList<StringBuilder>(numRows);
        for(int i = 0; i < numRows; i++) list.add(new StringBuilder());
        // 定义Flage
        int flage = -1;
        int length = numRows - 1;
        int i = 0;
        char [] chars = s.toCharArray();
        for(char c: chars){
            StringBuilder builder = list.get(i);
            builder.append(c);
            if(i == 0 || i ==length) flage = -flage;
            i = i + flage;

        }
        StringBuilder strs = new StringBuilder();
        for(StringBuilder builder :list){
            strs.append(builder.toString());
        }
        return strs.toString();
    }
}