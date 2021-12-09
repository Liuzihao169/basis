package alg.leetcode;

import java.util.*;

/**
 * @author liuzihao
 * @create 2021-11-08-21:49
 */
public class Demo49 {
    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        System.out.println(solution49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char [] a = strs[i].toCharArray();
            Arrays.sort(a);
            String key = Arrays.toString(a);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else{
                List<String> str = new ArrayList<>();
                str.add(strs[i]);
                map.put(key, str);
            }
        }
        return new ArrayList<>(map.values());
    }
}