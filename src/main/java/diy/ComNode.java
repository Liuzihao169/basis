package diy;

/**
 * @author liuzihao
 * @create 2020-11-20-22:23
 */
public class ComNode<T> {
   public T t;
   public ComNode next;
   public ComNode silbing;

    public ComNode(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "ComNode{" +
                "t=" + t +
                '}';
    }
}
