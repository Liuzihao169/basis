package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author hao
 * @create 2019-08-01 ${TIM}
 */
public class CglibPoxy implements MethodInterceptor {
    /**
     * cglib的步骤
     * 1、实现 MethodInterceptor 编写拦截器逻辑(内部对想要增强的方法进行加强)
     * 2、生成一个Enhancer 将拦截器和目标类传入
     * 3、调用create()方法 生成一个代理
     * @param args
     */

    public static void main(String[] args) {
        CglibTarget porxy = CglibPoxy.newPorxy(CglibTarget.class);
        porxy.sport();

    }

    /**
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("sport")){
            System.out.println("================运动前热身================");
            Object invoke = methodProxy.invoke(o, objects);
            System.out.println("================运动后洗澡================");
            return invoke;

        }

        return methodProxy.invoke(o,objects) ;
    }

    public static CglibTarget newPorxy(Class<CglibTarget> targetClass){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback(new CglibPoxy());
        return (CglibTarget) enhancer.create();
    }
}
