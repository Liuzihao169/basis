package alg;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2022-01-23-11:01
 */
public class Demo326 {

    @Test
    public void test(){
        Solution326 solution326 = new Solution326();
        boolean powerOfThree = solution326.isPowerOfThree(27);
    }

}
class Solution326 {
    public boolean isPowerOfThree(int n) {
        if (n <3) return false;
        while(true){
            if(n%3 != 0){
                return false;
            }
            n = n/3;
            if(n < 1) return false;
            if(n == 1) return true;
        }
    }
}