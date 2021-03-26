package gof.factorymethod;

import gof.factorymethod.impl.BuckWheaBread;

/**
 * @author liuzihao
 * @create 2020-11-22-11:20
 * 荞麦面包按钮，用于生产荞麦面包
 */
public class BuckWheaBreadButtonFactory implements IFactory {
    @Override
    public Ibread createBread() {
        return new BuckWheaBread();
    }
}
