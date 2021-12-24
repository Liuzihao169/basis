package proxy.aop;

/**
 * @author liuzihao
 * @create 2021-11-07-17:32
 */
public class Service1 {

    public void m1() {
        System.out.println("我是 m1 方法");
    }

    public void m2() {
        System.out.println(10 / 0);
        System.out.println("我是 m2 方法");
    }
}
