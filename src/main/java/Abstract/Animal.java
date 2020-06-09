package Abstract;

/**
 * @author hao
 * @create 2019-07-09 ${TIM}
 */
public abstract  class Animal {
    //定义speak 这个抽象方法 子类必须实现这个方法
    public abstract void speaking();

    //定义普通方法
    public void happy(){
        System.out.println("i am happy");
    }
}

class  Dog extends Animal{
    //实现Animal定义的抽象方法
    @Override
    public void speaking() {
        System.out.println("汪汪汪...");
    }
}

class  Cat extends Animal{
    //实现Animal定义的抽象方法
    @Override
    public void speaking() {
        System.out.println("喵喵喵...");
    }
}
