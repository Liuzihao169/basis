package io.inputstream;

import java.io.*;

/**
 * @author hao
 * @create 2019-07-27 ${TIM}
 * 以字节流的形式读取
 * 读取c.txt中的数据
 * c.txt中的内容 只有一个字符 A
 */
public class InputStreamFile {
    public static void main(String[] args) throws IOException {
        //获得流
        InputStream inputStream = new FileInputStream(new File("D:\\testfile\\c.txt"));
        //将获得流的byte 存储在int中
        int read = inputStream.read();
        System.out.println(read);//输出结果65
        //关流
        inputStream.close();
    }
}
