package alg.tooffer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzihao
 * @create 2021-02-20-10:04
 * 第一个只出现一次的字符:
 * 例如：'abaccdeff' 则输出 b
 */
public class Demo50 {
    /**
     * 利用hash 表记录 每个字母k 及出现的次数 v
     * 解题思路：
     * 第一次遍历记录 每个字符的次数、第二次遍历记录第一次出现 1次的字母
     */
    @Test
    public void test(){
        String str = "abaccdeff";
        Map<Character,Integer> map = new HashMap<>();
        int index = 0;
        while (index<= str.length() - 1) {
            Character key = Character.valueOf((char) (str.charAt(index) - 'a'));
            map.merge(key, 1, (a, b) -> a + b);
            index++;
        }

        Character character = getOneExist(map);
        System.out.println(character);

    }

    private Character getOneExist(Map<Character, Integer> map) {
        for (Character character : map.keySet()) {
            if (map.get(character) == 1) {
                return (char)(character.charValue() + 'a');
            }
        }
        return null;
    }
}
