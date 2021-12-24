package alg;

/**
 * @author liuzihao
 * @create 2021-10-22-22:07
 * "mississippi"
 * "issip"
 */
public class Demo2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.strStr("mississippi", "issip"));
    }

}
class Solution2 {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle)) {
            return 0;
        }
        if(needle.length() == 0) {
            return 0;
        }
        int index = -1;
        for(int i = 0; i < haystack.length(); i++) {
            if( haystack.length() - i >= needle.length() && haystack.charAt(i) == needle.charAt(0)){
                index = i;
                int temp = i;
                for(int j = 1; j < needle.length(); j++) {
                    if(needle.charAt(j) != haystack.charAt(++temp)){
                        index = -1;
                        break;
                    }
                }
                if(index != -1) {
                    return index;
                }
            }
        }
        return index;
    }
}