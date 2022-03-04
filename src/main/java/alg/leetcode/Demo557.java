package alg.leetcode;

/**
 * @author liuzihao
 * @create 2022-02-06-16:19
 */
public class Demo557 {


    public static void main(String[] args) {

    }
}

class Solution557 {
    public String reverseWords(String s) {
        String [] strs =  s.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < strs.length; i++){
            builder.append(resver(strs[i]));
            if(i != strs.length -1 ){
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    public String resver(String str ){
        StringBuilder builder = new StringBuilder();
        for(int i = str.length() -  1  ; i >=0; i-- ) {
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }
}
