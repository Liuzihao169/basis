package proxy;

/**
 * @author hao
 * @create 2019-07-30 ${TIM}
 */
public class Human implements Activity {
    @Override
    public void sport() {
        System.out.println("我在运动...");
    }

    @Override
    public void eat() {
        System.out.println("我在吃饭....");
    }

    @Override
    public void sleep() {
        System.out.println("我在睡觉");
    }
}
