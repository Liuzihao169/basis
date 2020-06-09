package serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author hao
 * @create 2019-09-03 ${TIM}
 * 定义一个可以序列化的 商品类
 */
public class Product implements Serializable {
    private String name;
    private double price;
    private String describe;

    public Product() {
    }

    public Product(String name, double price, String describe) {
        this.name = name;
        this.price = price;
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", describe='" + describe + '\'' +
                '}';
    }
    //自定义 方法
    private   void writeObject(ObjectOutputStream s) throws IOException {
        s.writeObject("name");
        s.writeObject("describe");
    }

    private void  readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        name = "自定义更改name";
        describe = (String) s.readObject();
    }
}
