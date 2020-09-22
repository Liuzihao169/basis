package gof.observer;

/**
 * @author liuzihao
 * @create 2020-09-20-19:18
 */
public class MainDemo {
    public static void main(String[] args) {
        //1、初始化被观察者(媒婆)
        SubjectI subjectI = new SubjectMeiPo();
        // 2、初始化观察者
        ObserverI lw = new ObserverW(subjectI);
        ObserverI lz = new ObserverZ(subjectI);
        ObserverI ll = new ObserverL(subjectI);
        System.out.println("准备工作完毕");

        System.out.println("哇!- 我收到了一个小姐姐的消息赶紧通知他们 ");
        subjectI.notifyObserver();
        System.out.println("全部通知完咯，那就看他们谁先抢到吧");

    }
}
