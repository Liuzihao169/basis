package io.writer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

/**
 * @author hao
 * @create 2019-07-27 ${TIM}
 * 复制字符流
 * 将a.txt的文本内容复制到b.txt中
 */
public class CopyFile {
    public static void main(String[] args) throws Exception{
        int len = 0;
        char [] temp = new char[1024];
        //声明字符读取流b
        Reader reader = new FileReader(new File("D:\\testfile\\a.txt"));
        //字符输出流
        FileWriter fileWriter = new FileWriter(new File("D:\\testfile\\b.txt"));
        while ((len=reader.read(temp))>0){
            fileWriter.write(temp,0,len);
            //每次都要刷新写入
            fileWriter.flush();
        }
        //关闭资源
        fileWriter.close();
        reader.close();
    }
}
