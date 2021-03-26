package gof.factorymethod;


import gof.factorymethod.impl.Breakbread;
import gof.factorymethod.impl.BuckWheaBread;

/**
 * @author liuzihao
 * @create 2020-11-22-11:29
 */
public class DemoTest {

    public static void main(String[] args) {
        // 生产黑面包
        IFactory iFactory = new BreakBreadButtonFactory();
        Ibread breakBread = iFactory.createBread();
        System.out.println(breakBread.desc());

        // 生产荞麦面包
        IFactory factory = new BuckWheaBreadButtonFactory();
        Ibread buck = factory.createBread();
        System.out.println(buck.desc());

    }

    public Ibread create(String type) {
        switch (type) {
            case "1":
                return new Breakbread();
            case "2":
                return new BuckWheaBread();
            default:
                throw new RuntimeException("不支持改类型");
        }
    }
}
