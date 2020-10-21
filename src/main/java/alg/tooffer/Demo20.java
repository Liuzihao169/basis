package alg.tooffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzihao
 * @create 2020-10-21-20:25
 * 面试题20：判断字符是否是数字
 * "1.2e5" "1E2"
 */
public class Demo20 extends DemoBase {
    /**
     * 解题思路：
     * 进行模式匹配：
     * 数字：A[[.B]][e|EC] 或 .B[e|EC]
     * 最后判断： 是否已经到达字符串末尾
     */
    @Test
    public void test(){
        System.out.println(match("99.98E3"));
    }
    public boolean match(String string) {
        if (string == null || "".equals(string)) {
            return false;
        }
        List<Integer> indx = new ArrayList<>(1);
        indx.add(0,0);
        boolean number = scanInter(indx, string);
        //判断小数点
        if (indx.get(0)<string.length() -2 &&".".equals(String.valueOf(string.charAt(indx.get(0) + 1)))) {
            indx.add(0,indx.get(0) + 1);
            // 小数点前面可以没有数字
            number = number || scanInter(indx, string);
        }
        if (indx.get(0)<string.length() -2&&("E".equals(String.valueOf(string.charAt(indx.get(0) + 1))) || "e".equals(String.valueOf(string.charAt(indx.get(0) + 1))) )) {
            indx.add(0,indx.get(0) + 1);
            number = number && scanInter(indx, string);
        }
        // 符合条件并且到了最后一个字符
        return number && (indx.get(0)== string.length() - 1);
    }

    /**
     * 对数字进行扫描
     * @param index
     * @param string
     * @return
     */
    public boolean scanInter(List<Integer>index,String string) {
        int j = 0;
        for (int i = index.get(0); i <= string.length() - 1; i++) {
            //判断数字
            if ("+".equals(String.valueOf(string.charAt(i)) ) || "-".equals(string.charAt(i))) {
                continue;
            }
            if ((string.charAt(i) >= '0' && string.charAt(i) <='9')) {
                j = i;
            }
        }
        index.add(0,j);
        return j> 0;
    }

}
