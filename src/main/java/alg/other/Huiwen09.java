package alg.other;

/**
 * @author liuzihao
 * @create 2021-10-13-23:20
 * 回文
 */
public class Huiwen09 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1121));
    }

    /**
     * 首尾判断
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String a = x +"";
        for (int i = 0; i < a.length() / 2; i++) {
            if (a.charAt(i) != a.charAt(a.length() - 1 -i)){
                return false;
            }
        }
    return true;
    }
}
