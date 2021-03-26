package gof.abstractfactory;

import gof.abstractfactory.productA.BreakBread;
import gof.abstractfactory.productA.IbreadProductA;
import gof.abstractfactory.productB.CreamIce;
import gof.abstractfactory.productB.IceCreamProductB;

/**
 * @author liuzihao
 * @create 2020-12-12-23:01
 * 工厂1
 */
public class ConcreteFactroy1 implements AbstractFactory{
    @Override
    public IbreadProductA creatProductA() {
        return new BreakBread();
    }

    @Override
    public IceCreamProductB creatProductB() {
        return new CreamIce();
    }
}
