package alg.tooffer;

import com.sun.xml.internal.bind.v2.model.core.ID;
import datastructure.tree.Tpnode;
import javafx.scene.shape.HLineTo;
import org.junit.Before;
import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-09-13-11:28
 * 题目8：二叉树的下一个节点 （每个节点都包含父亲节点的引用）
 *        a
 *      /  \
 *     b   c
 *    / \  /\
 *   d  e f g
 *     /\
 *    h i
 * 中序遍历：【d b h e i a f c g】
 */
public class Demo8 {

   Tpnode root;

   @Before
   public void bulidTree() {
        this.root = new Tpnode("a");
       Tpnode<String> b = new Tpnode("b");
       Tpnode<String> c = new Tpnode("c");
       Tpnode<String> d = new Tpnode("d");
       Tpnode<String> e = new Tpnode("e");
       Tpnode<String> f = new Tpnode("f");
       Tpnode<String> g = new Tpnode("g");
       Tpnode<String> h = new Tpnode("h");
       Tpnode<String> i = new Tpnode("i");
       root.lchild = b;
       root.rchild = c;
       b.fNode = root;
       c.fNode =root;

       b.lchild = d;
       b.rchild= e;
       d.fNode = b;
       e.fNode = b;

       c.lchild =f;
       c.rchild = g;
       f.fNode = c;
       g.fNode = c;

       e.lchild = h;
       e.rchild = i;
       h.fNode = e;
       i.fNode = e;
   }


    /**
     * 解题思路：
     * 1、如果该节点有右子树(右孩子是非叶子节点)==》下一个节点是子树中最左节点  例如：b -> h
     * 2、如果该节点是 右叶子节点 ==》 下一个节点是父亲节点 例如：h -> e
     * 3、如过该节点是 左叶子节点 ==》 找祖先节点是某个节点都左孩子节点，改祖先节点的的父节点就是下一个节点
     * 例如 i -> a
     * g -> 无  （因为g 找不到符合条件的下一个节点）
     */
    @Test
    public void test(){
        Tpnode a = findNextNode("g", root);
        if (a == null) {
            System.out.println("没有下一个节点");
        }else {
            System.out.println("中序遍历时的下一个节点是"+a.data);
        }
    }

    Tpnode findNextNode(String date,Tpnode root) {
        Tpnode bydate = findBydate(date, root);
        if (bydate == null) {
            throw new RuntimeException("树中不存在这个节点");
        }
        // 情况1
        if (bydate.rchild !=null && bydate.rchild.rchild !=null) {
            Tpnode curr = bydate.rchild;
            while (curr.lchild != null) {
                curr = curr.lchild;
            }
            return curr;
        }
        // 情况2 左叶子节点
        else  if (bydate.lchild ==null
                && bydate.rchild ==null
                && bydate.fNode != null
                 ) {
            if (bydate.fNode.lchild.equals(bydate)) {
                return bydate.fNode;
            }else {
                // 右叶子节点
                Tpnode cur = bydate;
                while (cur.fNode != null && !cur.fNode.lchild.equals(cur)) {
                    cur = cur.fNode;
                }
                return cur.fNode;
            }
        }

        return null;
    }

    Tpnode findBydate(String date,Tpnode root) {
       if (root != null) {
           if (root.data.equals(date)){
               return root;
           }
           // 左孩子递归
           Tpnode bydate = findBydate(date, root.lchild);
           if (bydate != null) {
               return bydate;
           }
           // 右孩子递归
           Tpnode bydate1 = findBydate(date, root.rchild);
           if (bydate1 != null) {
               return bydate1;
           }
       }
       return null;
    }
}
