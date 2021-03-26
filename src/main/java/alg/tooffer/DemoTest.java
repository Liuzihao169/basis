package alg.tooffer;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author liuzihao
 * @create 2021-01-10-09:39
 */
public class DemoTest {

    @Test
    public void dosom(){
        String a = "\n123\n";
        String s = a.replaceAll("\n|\r","");
        System.out.println(s);
    }

    @Test
    public void test2(){
        String a = "String(12)";
        System.out.println(a.toLowerCase());
        System.out.println("123");
        System.out.println(new BigDecimal("12"));
    }

    /**
     * 自线程并不会影响主要线程
     * @throws Exception
     */
    @Test
    public void test() throws Exception{
        Thread thread = new Thread(()->{
            for(int i =0; i<100; i++) {
                try {
                    Thread.sleep(100);

                }catch (Exception ex) {

                }
                if (i ==20) {
                    throw new RuntimeException("子线程抛出异常");
                }
            }
        });
        thread.start();
        thread.join();

        System.out.println("main 线程执行");
    }
}
