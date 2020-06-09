package io.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author hao
 * @create 2019-07-27 ${TIM}
 */
public class BufferedReaderFile {
    public static void main(String[] args) throws Exception {
        BufferedReader readerFile = new BufferedReader(new FileReader(new File("D:\\testfile\\a.txt")));
        /**
         * 使用readLine()每次读取一行 当有数据时候 返回读取到行内容  当没有数据的时候 返回null
         */String len = null;
        while ((len=readerFile.readLine())!=null){
            System.out.println(len);
        }
        readerFile.close();
    }
}
