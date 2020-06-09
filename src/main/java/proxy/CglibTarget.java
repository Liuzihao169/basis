package proxy;

/**
 * @author hao
 * @create 2019-08-01 ${TIM}
 */
public class CglibTarget implements CglibPoxyInterface{

    public void sport(){
        System.out.println("我在运动");
    }
}
