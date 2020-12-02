package alg.tooffer;

import datastructure.tree.Tnode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzihao
 * @create 2020-11-25-22:45
 * 面试题37：序列化二叉树
 */
public class Demo37 extends DemoBase {
    int index = 0;
    /**
     * 解题思路：
     * 1、先将二叉树序列化成 字符串序列 null 用特殊字符%代替
     * 2、根据字符串反序列化
     * 反序列化时，构建 拆散成 根节点、左子树、右子树 然后左右子树进行递归
     */
    @Test
    public void test(){
        Tnode tnode = InitializeTree2();
        String serString =  serNode2String(tnode);
        String[] split = serString.split(",");
        List<Integer> list = new ArrayList<>(1);
        list.add(0,0);
        Tnode node = serString2Node(split);
        System.out.println(node);
    }


    private Tnode serString2Node(String [] str) {
        if (index > str.length - 1) {
            return null;
        }
        if ("%".equals(str[index])) {
            index++;
            return null;
        }
        Tnode tnode = new Tnode(Integer.parseInt(str[index]));
        index++;
        tnode.lchild = serString2Node(str);
        tnode.rchild = serString2Node(str);
        return tnode;
    }

    private String serNode2String(Tnode tnode) {
        StringBuilder stringBuilder = new StringBuilder();
        preOrder(tnode, stringBuilder);
        return stringBuilder.toString();
    }

    private void preOrder(Tnode tnode, StringBuilder stringBuilder) {
        if (tnode != null) {
            stringBuilder.append(tnode.data+",");
            preOrder(tnode.lchild, stringBuilder);
            preOrder(tnode.rchild,stringBuilder);
        }else {
            stringBuilder.append("%,");
        }
    }
}
