package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzihao
 * @create 2021-11-28-09:52
 */
public class Demo93 {

    public static void main(String[] args) {
        Solution93 solution93 = new Solution93();
        List<String> list = solution93.restoreIpAddresses("0000");
        System.out.println(list);
    }
}

class Solution93 {

    List<String> list = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, new StringBuilder(), 0);
        return list;
    }

    public void dfs(String s, int start, StringBuilder builder, int depth) {



        if (depth == 4) {
            builder.deleteCharAt(builder.length() - 1);
            list.add(builder.toString());
            return;
        }
        if (start >= s.length()){
            return;
        }
        if(s.charAt(start) == '0'){
            if(depth == 3 && start != s.length()-1){
                return;
            }
            builder.append("0");
            builder.append(".");

            dfs(s, start+1,builder ,depth+1);
            if(builder.charAt(builder.length() - 1)  =='.') {
                builder.deleteCharAt(builder.length() - 1);
            }
            builder.delete(builder.length() - 1, builder.length());

        }else {
            if(depth == 3){
                if(s.substring(start).length() > 3 ||Integer.parseInt(s.substring(start)) > 255 ) {
                    return;
                }
                builder.append(s.substring(start));
                builder.append(".");
                dfs(s, s.length() , builder, depth + 1);
                //builder.deleteCharAt(builder.length() - 1);
                builder.delete(builder.length() - s.substring(start).length(), builder.length());


            }else {
                for (int i = 1; i <= 3; i++) {
                    if (start + i > s.length()) {
                        return;
                    }
                    String a = "";

                    a = s.substring(start, start + i);

                    if (Integer.parseInt(a) <= 255) {
                        // 才往下传递
                        builder.append(a);
                        builder.append(".");
                        dfs(s, start + i, builder, depth + 1);
                        builder.deleteCharAt(builder.length() - 1);
                        builder.delete(builder.length() - i, builder.length());
                    }
                }
            }


        }


    }
}
