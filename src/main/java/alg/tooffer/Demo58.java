package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2021-09-25-10:17
 * 面试题58 要求反转句子中单词的顺序，但是单词内字符的顺序不能改变
 *
 * 例如 I am a stedent.   输出为： setdent. a am I
 *
 *
 */
public class Demo58 extends DemoBase {


    /**
     * 解题思路：
     * 方式一：
     * 1、先所有字符反转
     * 2、单个字符再次反转
     *
     * 方式二：
     * 1、空格切割后，倒叙相加补上空格；
      */
    @Test
   public void test(){
       String str = "I am a stedent.";
       String[] s = str.split(" ");
       String str1 = "";
       for (int i = s.length - 1; i >= 0; i--) {
           str1 += s[i];
           if (i>0){
               str1 +=" ";
           }
       }
       System.out.println(str1);
   }




}
