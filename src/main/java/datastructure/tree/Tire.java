package datastructure.tree;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2019/12/4-19:15
 * 字典树功能的实现
 */

// 字典树节点
class TireNode{
    char val;
    boolean isEnd;
    TireNode [] child = new TireNode[26];
    public TireNode(char val){
        this.val = val;
    }
}

//字典树
public class Tire {
    private TireNode root = new TireNode(' ');
    public Tire(){
    }
    // 插入的时候 a,b,c,d 顺序存储
    public void insert(String word) {
        TireNode cur = root;
        //插入操作
        for (int i = 0 ;i<word.length();i++){
            char c = word.charAt(i);
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new TireNode(c);
            }
            cur = cur.child[c - 'a'];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TireNode cur = root;
        //根据字母顺序往下 循环查找
        for (int i = 0 ; i<word.length();i++){
            char c = word.charAt(i);
            if (cur.child[c - 'a'] == null) {
             return  false;
            }
            cur = cur.child[c - 'a'];
        }
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TireNode cur = root;
        //根据字母顺序往下 循环查找
        for (int i = 0 ; i<prefix.length();i++){
            char c = prefix.charAt(i);
            if (cur.child[c - 'a'] == null) {
                return  false;
            }
            cur = cur.child[c - 'a'];
        }
        return true;
    }

    @Test
    public void testTire(){
        Tire tire = new Tire();
        tire.insert("apple");
        System.out.println(tire.search("apple"));
        System.out.println(tire.search("app"));
        System.out.println(tire.startsWith("app"));
        tire.insert("app");
        System.out.println(tire.search("app"));
    }
}
