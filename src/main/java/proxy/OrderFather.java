package proxy;

/**
 * @author hao
 * @create 2019-07-30 ${TIM}
 */
public class OrderFather {

    private int fatherint ;
    private String fatherstring;
    int fatherdefault;
    public int fatherpublic;

    private int getFatherint() {
        return fatherint;
    }

    public String getFatherstring() {
        return fatherstring;
    }

    protected int getFatherdefault() {
        return fatherdefault;
    }

    public int getFatherpublic() {
        return fatherpublic;
    }
}
