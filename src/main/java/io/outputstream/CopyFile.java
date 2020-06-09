package io.outputstream;

import java.io.*;

/**
 * @author hao
 * @create 2019-07-27 ${TIM}
 */
public class CopyFile {
    public static void main(String[] args) {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        try {
            long start = System.currentTimeMillis();
            in = new BufferedInputStream(new FileInputStream("D:\\testfile\\a\\海阔天空.mp3"));
            out = new BufferedOutputStream(new FileOutputStream("D:\\testfile\\b\\海阔天空.mp3"));
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
