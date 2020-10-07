package gof.decoratoer;

/**
 * @author liuzihao
 * @create 2020-10-07-12:01
 */
public class DemoMain {
    public static void main(String[] args) {
        JbComponent jbComponent1 = new JbComponenthHotDog();
        System.out.println("卖" + jbComponent1.desc() + "\t 价格" +jbComponent1.price());
        JbComponent jbComponent2 = new JbComponenteEgg();
        System.out.println("卖" + jbComponent2.desc() + "\t 价格" +jbComponent2.price());
        JbComponent jbComponent3 = new JbComponentPancakes();
        System.out.println("卖" + jbComponent3.desc() + "\t 价格" +jbComponent3.price());

        System.out.println("==开始卖包装产品==");
        JbComponent jbComponent4 = new DecoratorPancakesWithEgg(jbComponent3);
        System.out.println("卖" + jbComponent4.desc() + "\t 价格" +jbComponent4.price());
        JbComponent jbComponent5 = new DecoratorPancakesWithEgg(jbComponent4);
        System.out.println("卖" + jbComponent5.desc() + "\t 价格" +jbComponent5.price());


    }
}
