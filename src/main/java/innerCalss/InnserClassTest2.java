package innerCalss;

/**
 * @author hao
 * @create 2019-07-10 ${TIM}
 * 静态内部类
 */
public class InnserClassTest2 {
    public static void main(String[] args) {
        OuterClass2.Inner2 inner2 = new OuterClass2.Inner2();
        inner2.show(); //输出结果 jack
    }
}

class OuterClass2{
    private  int age = 10;
    private static  String name = "jack";


  static  class Inner2{
        public void show(){
         //   System.out.println(OuterClass2.this.age); 编译无法通过 不能访问外部类 非静态成员
            System.out.println(name);
        }
    }
}
