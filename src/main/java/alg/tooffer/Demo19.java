package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-10-18-10:11
 * 面试题19：正则表达式匹配
 * aaa  a.a
 * aaa  ac*a
 * 非确定有限状态机
 * b a * a b
 * b a a a a b
 */
public class Demo19 extends DemoBase {


    @Test
    public void test(){
        System.out.println(match("aaa", "a.a"));
        System.out.println(match("aaa", "ab*ac*a"));
        System.out.println(match("","a.a"));

    }
    /**
     * 解题思路利用递归；
     * 需要注意的点，模式中 a*时有两种路径，跳过a* 或者继续比较
     * @param string
     * @param par
     * @return
     */
    private boolean match(String string, String par) {
        if (null == string || null == par) {
            return false;
        }
        return matchCore(string,0, par,0);
    }

    private boolean matchCore(String string,int stringStart,  String par,int parStart) {
        if (stringStart >= string.length() && parStart >= par.length()){
            return true;
        }
        if ("".equals(string) && "".equals(par)) {
            return true;
        }
        if ("".equals(string)||"".equals(par)) {
            return false;
        }

        // 如果第二位是 *
        if (parStart + 1 <= par.length() -1 && "*".equals(String.valueOf(par.charAt(parStart + 1)))) {
            /**
             * 如果当前匹配：三种选择（par + 2、str【忽略已经匹配的】）、(par + 2、str + 1)、（par, str + 1）
             * 当前匹未匹配：一种选择（跳两位）
             */
            if (checkEqualAtIndex(string, stringStart, par, parStart)) {
                return matchCore(string,stringStart, par , parStart + 2)||
                        matchCore(string,stringStart + 1, par , parStart)||
                        matchCore(string,stringStart + 1, par , parStart + 2);
            }else {
                return matchCore(string,stringStart, par , parStart + 2);
            }
        }

        // 完全匹配 或者出现 .
        if (checkEqualAtIndex(string, stringStart, par, parStart)){
            return matchCore(string, stringStart + 1, par, parStart + 1);
        }
        return false;
    }

    private boolean checkEqualAtIndex(String string, int stringStart, String par, int parStart) {
        return string.charAt(stringStart) == par.charAt(parStart) || ".".equals(String.valueOf(par.charAt(parStart)));
    }

    @Test
    public void test2(){
    String a =".";
        System.out.println(".".equals(a.charAt(0) + ""));
    }
}


