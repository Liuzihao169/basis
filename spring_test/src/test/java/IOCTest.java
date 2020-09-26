import com.kuake.bean.Car;
import com.kuake.bean.Dog;
import com.kuake.config.MyConfig1;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hao
 * @create 2019-08-07 ${TIM}
 */
public class IOCTest {
    AnnotationConfigApplicationContext applicationContext ;


    @Before
    public void before(){
        applicationContext=new AnnotationConfigApplicationContext(MyConfig1.class);
    }
    @After
    public void after(){
        applicationContext.close();
    }

    @Test
    public void test(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("====================>"+beanDefinitionName);
        }
        //多例的时候 直接获取
        applicationContext.getBean(Car.class);
        applicationContext.getBean(Dog.class);
        //Returning cached instance of singleton bean 'car'从缓存中获取
        System.out.println("==========再次获取==========");
        applicationContext.getBean(Car.class);
    }

    //测试工厂
    @Test
    public void test2(){
        //获得的 是创建的对象
        Object dogBeanFactory = applicationContext.getBean("dogBeanFactory");
        Object dogBeanFactory2 = applicationContext.getBean("dogBeanFactory");
        System.out.println(dogBeanFactory);
        System.out.println(dogBeanFactory2);
        System.out.println(dogBeanFactory==dogBeanFactory2);

        Object dogBeanFactory3 = applicationContext.getBean("&dogBeanFactory");
        System.out.println(dogBeanFactory3);
    }

    @Test
    public void test3(){

    }
}
