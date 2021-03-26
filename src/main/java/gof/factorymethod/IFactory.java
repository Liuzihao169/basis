package gof.factorymethod;

/**
 * @author liuzihao
 * @create 2020-11-22-11:16
 * 工厂接口，用于生产面包
 */
public interface IFactory {
    /**
     * 创建一个面包
     * @return
     */
    Ibread createBread();
}
