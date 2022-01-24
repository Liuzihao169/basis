package alg.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzihao
 * @create 2022-01-19-22:52
 */
public class Demo146 {

    class LRUCache {
        /**
         * 解题思路: LRU 最近最少使用，可以使用双向链表 维护
         * 队头保证最新数据，如果达到 容量 那么淘汰队尾
         * put操作也是放在最前面
         *
         * */
        class LinkNode{
            LinkNode pre;
            LinkNode next;
            int val;
            int key;
            public  LinkNode(int val,int key){
                this.key = key;
                this.val = val;
            }
            public LinkNode(){}
        }

        LinkNode tail;
        LinkNode head;
        int size;
        int capacity;
        Map<Integer, LinkNode> map = new HashMap<Integer, LinkNode>();
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            tail = new LinkNode();
            head = new LinkNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            LinkNode node = map.get(key);
            if(node == null){
                return -1;
            }
            moveToFirst(node);
            return node.val;
        }

        public void put(int key, int value) {
            if(get(key) != -1){
                map.get(key).val =  value;
            }else{
                LinkNode node = new LinkNode(value,key);
                map.put(key, node);
                size++;
                moveToHead(node);
                if(size > capacity){
                    LinkNode tmp1 = tail.pre;
                    deleteCurNode(tail.pre);
                    map.put(tmp1.key,null);
                }
            }
        }

        public void moveToFirst(LinkNode node){
            if(node.next != head){
                deleteCurNode(node);
                moveToHead(node);
            }
        }

        public void deleteCurNode(LinkNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public void moveToHead(LinkNode node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

    }

    @Test
    public void test(){
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // 缓存是 {1=1}
        lRUCache.get(1);

    }


}
