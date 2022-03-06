package gof.Singleton;

/**
 * @author liuzihao
 * @create 2022-03-05-19:43
 * 占位模式获取 使用时才会加载初始化
 */
public class SlingletonBulid {

    /**
     * 获取时才被初始化
     * @return
     */
    public static SlingletonBulid getSlingleton(){
        return SlingletonFactroy.slingletonBulid;
    }


    private static class SlingletonFactroy{
        public static SlingletonBulid slingletonBulid = new SlingletonBulid();
    }
}
