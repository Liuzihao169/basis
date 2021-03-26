package gof.factorymethod;

import gof.factorymethod.impl.Breakbread;

/**
 * @author liuzihao
 * @create 2020-11-22-11:18
 * 黑面包按钮，用于生产黑面包
 */
public class BreakBreadButtonFactory implements IFactory {
    @Override
    public Ibread createBread() {
        return new Breakbread();
    }
}
