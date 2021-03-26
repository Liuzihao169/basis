package gof.abstractfactory;

import gof.abstractfactory.productA.IbreadProductA;
import gof.abstractfactory.productB.IceCreamProductB;

/**
 * @author liuzihao
 * @create 2020-12-12-22:59
 * 抽象工厂，生产两种商品
 */
public interface AbstractFactory {

    IbreadProductA creatProductA();

    IceCreamProductB creatProductB();
}
