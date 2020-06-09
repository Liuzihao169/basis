package proxy;

/**
 * @author hao
 * @create 2019-07-30 ${TIM}
 */


public class Order extends  OrderFather{


    public  String oid = "00001";//订单的编号
    double total;//该订单的总金额
    private int state = 1;//表示支付状态1表示字符 0 表示没有支付


    public Order(String oid, double total, int state) {
        this.oid = oid;
        this.total = total;
        this.state = state;
    }

    public Order() {
    }

    private Order(double total) {
        this.total = total;
    }

    public String getOid() {
        return oid;
    }

    private void setOid(String oid) {
        this.oid = oid;
    }

    public double getTotal() {
        return total;
    }

    private void setTotal(double total) {
        this.total = total;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void happy(int a){
        System.out.println("我很开心第"+a+"次");
    }

    private void cry(){
        System.out.println("我要哭了");
    }
}
