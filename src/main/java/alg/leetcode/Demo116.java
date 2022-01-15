package alg.leetcode;

/**
 * @author liuzihao
 * @create 2022-01-03-10:38
 */
public class Demo116 {
    public static void main(String[] args) {
        Node root = new Node(1,
                new Node(2,new Node(4),new Node(5),null),
                new Node(3, new Node(6),new Node(7),null),null);
        Solution116 solution116 = new Solution116();
        solution116.connect(root);
    }
}
class Solution116 {
    public Node connect(Node root) {
        doLink(root,null,false);
        return root;
    }
    void doLink(Node root,Node pre,boolean isRight){
        if(root !=null) {
            System.out.println("处理当前节点: " + root.val);

            if (!isRight) {
                if (pre == null) {
                    root.next = null;
                    System.out.println("当前节点的next : " + null);
                }else {
                    root.next = pre.right;
                    System.out.println("当前节点的next : " + pre.right.val);

                }
            }else {
                if (pre == null || pre.next == null){
                    root.next = null;
                    System.out.println("当前节点的next : " + null);

                }else {
                    root.next = pre.next.left;
                    System.out.println("当前节点的next : " + pre.next.left.val);

                }
            }
            doLink(root.left,root,false);
            doLink(root.right, root,true);
        }
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}