package gof.Singleton;

/**
 * @author hao
 * @create 2019-07-31 ${TIM}
 * 懒汉模式 双重检查实现
 */
public class DubboCheckSingleton {
    // 防止发生重排
    private volatile static DubboCheckSingleton singleton;
    private DubboCheckSingleton(){}
    //提供一个获得实例化的方法

    public static DubboCheckSingleton getSingleton() {
        //创建出来之后 其他线程的检查
        if (singleton == null) {
            synchronized (DubboCheckSingleton.class){
                //检查一次创建
                if (singleton==null){
                    singleton = new DubboCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
