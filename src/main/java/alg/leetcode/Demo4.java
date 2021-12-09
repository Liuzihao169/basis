package alg.leetcode;

/**
 * @author liuzihao
 * @create 2021-10-21-11:13
 */
public class Demo4 {
    public static void main(String[] args) {
        Solution04 solution04 = new Solution04();
        solution04.plusOne(new int[]{9});
    }
}

class Solution04 {
    private int[] digits;
    public int[] plusOne(int[] digits) {
        this.digits = digits;
        plusOne(digits.length - 1);
        return digits;
    }

    public void plusOne(int index){
        if(index < 0){
            digits = bigger(digits);
            return;
        }
        if(digits[index] == 9) {
            digits[index] = 0;
            plusOne(index - 1);
            return;
        }
        //
        if(digits[index] < 9){
            digits[index] = digits[index] + 1;
        }
    }

    public int[] bigger(int[] digits){
        int [] newDigits = new int[digits.length + 1];
        for(int i = 0; i<digits.length; i++ ){
            newDigits[i+1] = digits[i];
        }
        newDigits[0] = 1;
        return newDigits;
    }
}