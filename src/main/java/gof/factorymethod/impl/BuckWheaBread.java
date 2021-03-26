package gof.factorymethod.impl;

import gof.factorymethod.Ibread;

/**
 * @author liuzihao
 * @create 2020-11-22-11:16
 */
public class BuckWheaBread implements Ibread {
    @Override
    public String desc() {
        return "荞麦面包";
    }
}
