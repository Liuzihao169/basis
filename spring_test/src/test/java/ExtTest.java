import com.kuake.config.ExtConfig;
import com.kuake.config.MyConfig1;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hao
 * @create 2019-08-15 ${TIM}
 */
public class ExtTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig1.class);
        applicationContext.close();
    }
}
