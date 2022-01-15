package alg.leetcode;

/**
 * @author liuzihao
 * @create 2022-01-04-22:30
 */
public class Demo134 {

    public static void main(String[] args) {
        Solution134 solution134n = new Solution134();
        System.out.println(solution134n.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}

class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = -1;
        int length = gas.length;
        for(int i =0; i< gas.length; i++){
            boolean flag = false;

            if(gas[i]>=cost[i]){
                start = i;
                int count = 0;
                int gasvalue = 0;
                int j = i;
                while(true){
                    if(count > gas.length){
                        flag = true;
                        break;
                    }

                    if(gasvalue +  gas[j%length] < cost[j%length]){
                        start = -1;
                        break;
                    }
                    gasvalue = gasvalue + gas[j%length] -  cost[j%length];
                    count++;
                    j++;
                }
            }
            if(flag){
                break;
            }
        }
        return start;
    }
}
