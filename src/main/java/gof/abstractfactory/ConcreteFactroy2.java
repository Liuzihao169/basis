package gof.abstractfactory;

import gof.abstractfactory.productA.BreakBread;
import gof.abstractfactory.productA.IbreadProductA;
import gof.abstractfactory.productB.IceCreamProductB;
import gof.abstractfactory.productB.MatchaIce;

/**
 * @author liuzihao
 * @create 2020-12-12-23:02
 * 工厂2
 */
public class ConcreteFactroy2 implements AbstractFactory{
    @Override
    public IbreadProductA creatProductA() {
        return new BreakBread();
    }

    @Override
    public IceCreamProductB creatProductB() {
        return new MatchaIce();
    }
}
