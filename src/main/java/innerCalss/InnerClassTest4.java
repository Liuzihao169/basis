package innerCalss;

/**
 * @author hao
 * @create 2019-07-10 ${TIM}
 */
public class InnerClassTest4 {
    public static void main(String[] args) {
        Outer outer  = new Outer();
        outer.show();
    }
}

class Outer{
    private  int age = 10;

    public  void show(){
        //作用范围只有该方法内
        class  Inner4{
            public void showAge(){
                System.out.println(age);
            }
        }

        //只能在方法内部定义
        Inner4 inner = new Inner4();
        inner.showAge();

    }

}
