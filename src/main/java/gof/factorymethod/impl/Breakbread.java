package gof.factorymethod.impl;

import gof.factorymethod.Ibread;

/**
 * @author liuzihao
 * @create 2020-11-22-11:15
 */
public class Breakbread implements Ibread {
    @Override
    public String desc() {
        return "黑面包";
    }
}
