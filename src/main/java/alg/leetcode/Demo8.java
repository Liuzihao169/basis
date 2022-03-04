package alg.leetcode;

/**
 * @author liuzihao
 * @create 2022-02-11-18:44
 */
public class Demo8 {
    public static void main(String[] args) {
        int i = myAtoi("99999999999999999999");
        System.out.println(i);
    }
    public static int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0){return 0;}
        // 首位不是 + - 数字 返回0
        if (!Character.isDigit(str.charAt(0))
                && str.charAt(0) != '-' && str.charAt(0) != '+'){
            return 0;
        }
        // 正数
        boolean isN =  (str.charAt(0) == '+' || Character.isDigit(str.charAt(0)));
        // 首位开始
        boolean isFist = Character.isDigit(str.charAt(0));
        int start = isFist?0:1;
        int res = 0;
        for(int i =start ; i<  str.length();i++){
            int cur =  str.charAt(i) - '0';
            int before = res;
            res = res*10 + (isN?1:-1)*cur;
            if(res/10 != before){
                if(isN){
                    return Integer.MAX_VALUE;
                }
                return Integer.MIN_VALUE;
            }
        }
        return res;
    }

}

