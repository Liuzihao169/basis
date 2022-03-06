package gof.Singleton;

/**
 * @author liuzihao
 * @create 2022-03-05-19:43
 * 饿汉模式 直接初始化
 */
public class HungryModeSlingleton {
    private static HungryModeSlingleton ourInstance = new HungryModeSlingleton();

    public static HungryModeSlingleton getInstance() {
        return ourInstance;
    }

    private HungryModeSlingleton() {
    }

}
