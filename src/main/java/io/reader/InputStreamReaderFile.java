package io.reader;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author hao
 * @create 2019-07-27 ${TIM}
 */
public class InputStreamReaderFile {
    public static void main(String[] args) throws Exception {
        InputStreamReader reader = new InputStreamReader(new FileInputStream("D:\\testfile\\b1.txt"),"GBK");
        int len = 0;
        char [] temp = new char[1024]; while ((len=reader.read(temp))>0){
            System.out.println(new String(temp,0,temp.length));
        }
        reader.close();
    }
}
