package io.outputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author hao
 * @create 2019-07-27 ${TIM}
 */
public class OutputStreamFile {
    public static void main(String[] args) throws Exception{
        //获得流
        OutputStream outputStream = new FileOutputStream(new File("D:\\testfile\\c.txt"));
        //字节数组输出
        outputStream.write("hello".getBytes());
        //关闭流
        outputStream.close();
    }
}
