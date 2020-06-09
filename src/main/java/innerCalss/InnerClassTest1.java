package innerCalss;

/**
 * @author hao
 * @create 2019-07-10 ${TIM}
 */
public class InnerClassTest1 {
    public static void main(String[] args) {

    OuterClass.Inner  inner = new OuterClass().new Inner();
    inner.show(); // 输出结果：10
    }
}

//外部类
class OuterClass{
    private  int age = 10;
    private static String name = "jack";

    //非静态成员内部类、
    class Inner{
    //static int age;    不能使用静态变量 编译会报错
        public void show(){
            System.out.println(OuterClass.this.age); //访问外部类的成员变量
            System.out.println(name);
        }
    }

}

