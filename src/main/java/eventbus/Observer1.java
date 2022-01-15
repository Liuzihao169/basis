package eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @author liuzihao
 * @create 2022-01-02-14:51
 */
public class Observer1 {

    @Subscribe
    public void toDo(String msg){
        System.out.println("Observer1 获得消息" + msg);
    }

    @Subscribe
    public void toDo2(String msg){
        System.out.println("Observer1 -toDo2 获得消息" + msg);

    }
}
