package io.outputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author hao
 * @create 2019-07-27 ${TIM}
 * 使用缓冲流来进行赋值
 */
public class CopyFile2 {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            long start = System.currentTimeMillis();
            in = new FileInputStream("D:\\testfile\\a\\海阔天空.mp3");
            out = new FileOutputStream("D:\\testfile\\b\\海阔天空.mp3");
            //临时缓存字节
            byte [] temp = new byte[1024];
            int len = 0;
            while ((len =in.read(temp))!=-1){
                //进行写出
                out.write(temp,0,len);
            }
            long end = System.currentTimeMillis();
            System.out.println("复制花费时间： "+(end-start));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(null!=in)in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(null!=out)out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

