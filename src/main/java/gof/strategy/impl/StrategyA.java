package gof.strategy.impl;

import gof.strategy.Strategy;

/**
 * @author liuzihao
 * @create 2020-09-13-18:08
 */
public class StrategyA implements Strategy {
    @Override
    public void doPlay() {
        System.out.println("我们去看电影啦");
    }
}
