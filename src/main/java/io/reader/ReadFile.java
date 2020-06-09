package io.reader;

import org.junit.Test;

import java.io.*;

/**
 * @author hao
 * @create 2019-07-27 ${TIM}
 */
public class ReadFile {
    public static void main(String[] args) throws Exception {
        /**
         * int  read(char cbuf[])方法 将读取的字符数 存储在cbuff的char数组中
         * 返回值:位读取字符的长度
         * 如果读到最后了 返回-1
         */
        int len = 0;
        char [] temp = new char[1024];
        Reader reader = new FileReader(new File("D:\\testfile\\a.txt"));
        while ((len=reader.read(temp))>0){
            System.out.println(new String(temp,0,temp.length));
        }
        //关流
        reader.close();
        }

        @Test
    public void test() throws Exception{
            Reader reader = new FileReader(new File("D:\\testfile\\a.txt"));
            int read = reader.read();
            System.out.println(read);
        }
}
