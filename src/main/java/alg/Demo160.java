package alg;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzihao
 * @create 2021-12-05-09:22
 */
public class Demo160 {
    public static void main(String[] args) {

    }
}

 class Solution160 {
    public List<Integer> getIntersectionNode(ListNode headA, ListNode headB) {
        List<Integer> a = getList(headA);
        List<Integer> b = getList(headB);
        int countA = a.size() ;
        int countB = b.size() ;
        int i = 1;
        Integer pre = null;
        while(countA >0 && countB >0){
            if(a.get(countA -i) == a.get(countB -i)) {
                pre = i;
                i++;
                continue;
            }
            break;
        }
        List<Integer> list = new ArrayList<>(2);
        if(pre == null){
            return list;
        }
        list.add(countA - i);
        list.add(countB - i);
        return list;
    }

    public List<Integer> getList(ListNode headA) {
        List<Integer> list = new ArrayList<>();
        while(headA !=null){
            list.add(headA.val);
            headA = headA.next;
        }
        return list;
    }
}