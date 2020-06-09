package io.writer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author hao
 * @create 2019-07-27 ${TIM}
 */
public class OutputStreamWriterFile {
    public static void main(String[] args ) throws Exception {
        FileOutputStream fos=new FileOutputStream("d:\\testfile\\a.txt");
        OutputStreamWriter opsw=new OutputStreamWriter(fos,"GBK");
        opsw.write("我好你好大家好");
        opsw.close();
    }

    @Test
    public void test() throws Exception{
        InputStreamReader reader = new InputStreamReader(new FileInputStream("D:\\testfile\\a.txt"),"GBK");
        OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream("d:\\testfile\\b.txt"),"UTF-8");
        int len = 0;
        char [] temp = new char[1024];
        while ((len=reader.read(temp))>0){
            writer.write(temp,0,len);
        }
        //关流
        reader.close();
        writer.close();
    }
}
