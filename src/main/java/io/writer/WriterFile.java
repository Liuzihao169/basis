package io.writer;

import java.io.File;
import java.io.FileWriter;

/**
 * @author hao
 * @create 2019-07-27 ${TIM}
 */
public class WriterFile {
    public static void main(String[] args) throws Exception {
        FileWriter fileWriter = new FileWriter(new File("D:\\testfile\\a.txt"));
        String s = "我来写出字符串";
        fileWriter.write("我来写出字符串");
        //刷新 写入
        fileWriter.flush();
        //关流
        fileWriter.close();
    }
}
