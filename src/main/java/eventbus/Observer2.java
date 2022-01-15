package eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @author liuzihao
 * @create 2022-01-02-14:51
 */
public class Observer2 {

    @Subscribe
    public void toDo(String msg){
        System.out.println("Observer2 获得消息:" + msg);
    }
}
