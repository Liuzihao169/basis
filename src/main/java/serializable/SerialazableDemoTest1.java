package serializable;

import java.io.*;

/**
 * @author hao
 * @create 2019-09-03 ${TIM}
 * //测试java对象的序列化 与反序列化
 */
public class SerialazableDemoTest1 {
    public static void main(String[] args) {
        Product product = new Product("电视机",3900.00,"这是一台高清");
        System.out.println("序列化之前"+product);
        // 序列化
        ObjectOutputStream  out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("D:\\a\\tempFile"));
            out.writeObject(product);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //反序列化
        ObjectInputStream in = null;
        Product pro = null;
        try {
            in = new ObjectInputStream(new FileInputStream("D:\\a\\tempFile"));
            //反序列读取
            pro = (Product) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("反序列化之后"+pro);

    }
}
