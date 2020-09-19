package gof.strategy;

import gof.strategy.impl.StrategyA;
import gof.strategy.impl.StrategyB;
import gof.strategy.impl.StrategyC;

/**
 * @author liuzihao
 * @create 2020-09-13-18:37
 */
public class MianDemo {
    public static void main(String[] args) {
        Strategy strategy = new StrategyA();
        Strategy strategy1 = new StrategyB();
        Strategy strategy2 = new StrategyC();

        System.out.println("====周末我们去玩哦======(想想 还是换一个)");
        strategy.doPlay();

        System.out.println("====周末我们去玩哦======(想想还是换一个)");
        strategy1.doPlay();

        System.out.println("====周末我们去玩哦======(其实就是想这个....)");
        strategy2.doPlay();

    }
}
