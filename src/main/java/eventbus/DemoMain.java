package eventbus;


import com.google.common.eventbus.EventBus;

/**
 * @author liuzihao
 * @create 2022-01-02-14:50
 */
public class DemoMain {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        Observer1 Observer1 = new Observer1();
        Observer2 Observer2 = new Observer2();

        eventBus.register(Observer1);
        eventBus.register(Observer2);

        eventBus.post("发送消息 啦啦啦.....");
    }
}
