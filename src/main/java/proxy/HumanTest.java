package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hao
 * @create 2019-07-30 ${TIM}
 * 目标 创建人的一个代理，让他在sport前 要热身 运动之后要洗澡
 */
public class HumanTest {

    public static void main(String[] args) {
        //创建一个代理对象
        Activity humanProxy = (Activity) Proxy.newProxyInstance(Human.class.getClassLoader(), Human.class.getInterfaces(), new InvocationHandler() {
            /**
             *
             * @param proxy
             * @param method
             * @param args
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("sport")) {
                    System.out.println("运动前的热身....");
                    method.invoke(new Human(), args);
                    System.out.println("运动后洗澡....");
                    return  null;
                }
                return method.invoke(new Human(), args);
            }
        });

        //使用代理对象 调用对应的方法
        humanProxy.sport();
        humanProxy.eat();
        humanProxy.sleep();
    }
}
