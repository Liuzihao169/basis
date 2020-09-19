package gof.strategy.impl;

import gof.strategy.Strategy;

/**
 * @author liuzihao
 * @create 2020-09-13-18:10
 */
public class StrategyC implements Strategy {

    @Override
    public void doPlay() {
        System.out.println("w我们去宾馆打游戏吧");
    }
}
