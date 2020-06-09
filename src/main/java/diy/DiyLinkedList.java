package diy;

/**
 * @author hao
 * @create 2019-07-15 ${TIM}
 */
public class DiyLinkedList {

    //首节点
    private Node fist;

    //尾部节点
    private Node last;

    // 元素个数
    private int size;

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      Node temp = fist;
      builder.append("[");
      while ( null!=temp){
          builder.append(temp.data+" ");
          temp = temp.sufix;
      }
      builder.append("]");
        return builder.toString();
    }

    public void add(Object o){
        Node node = new Node(null,null,o);
        if (null == fist){
            this.fist = node;
            this.last = node;
        }else{
            node.prefix = last;
            last.sufix = node;
            this.last = node;
        }
        //数量增加
        size++;
    }

    public static void main(String[] args) {
        DiyLinkedList diyLinkedList = new DiyLinkedList();
        diyLinkedList.add("A");
        diyLinkedList.add("B");
        diyLinkedList.add("C");
        diyLinkedList.add("D");
        System.out.println(diyLinkedList);
    }

}
