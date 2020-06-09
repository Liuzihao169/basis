package io.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @author hao
 * @create 2019-07-27 ${TIM}
 */
public class BufferedWriterFile {
    public static void main(String[] args) throws Exception{
        //构建字符缓冲区输出流
        //他的构造函数BufferedWriter(Writer out) 传入一个字符输入流
        //BufferedWriter特点：
        //1、当使用write(char cbuf[], int off, int len)会自动调用刷新
        //2、 close()方法的时候 会执行刷新动作
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("D:\\testfile\\a.txt")));
        writer.write("哈哈哈哈或");
        writer.newLine();
        writer.write("嘿嘿嘿嘿");
        writer.newLine();
        writer.write("嘿嘿嘿嘿");
        writer.newLine();
        writer.write("喵喵喵喵");

        //关闭资源（内部进行了刷新缓冲区）
        writer.close();
    }
}
