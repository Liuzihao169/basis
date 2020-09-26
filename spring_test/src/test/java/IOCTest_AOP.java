import com.kuake.aop.Machine;
import com.kuake.config.MyConfigAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class IOCTest_AOP {
    /**
     * 测试AOP的方法
     */
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfigAop.class);
		
		Machine machine = applicationContext.getBean(Machine.class);

        System.out.println(machine);
		machine.div(1, 1);
		
		applicationContext.close();
	}

}
