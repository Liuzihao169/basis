package gof.abstractfactory;

/**
 * @author liuzihao
 * @create 2020-12-12-23:04
 */
public class DemoMain {
    public static void main(String[] args) {


        System.out.println("老王的新店开张了.....");
        System.out.println("....一号产品....");
        AbstractFactory factory = new ConcreteFactroy1();
        System.out.println(factory.creatProductA().desc()+"..."+factory.creatProductB().desc());

        System.out.println("....二号产品....");
        AbstractFactory factory2 = new ConcreteFactroy2();
        System.out.println(factory2.creatProductA().desc()+"..."+factory2.creatProductB().desc());

        System.out.println("....期待三号产品....");


    }
}
