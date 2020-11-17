package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-11-17-21:02
 * 面试题33：二叉搜索树的后续遍历序列
 * 如果输入一个数组，判断该数组是否是二叉树的后序遍历结果
 */
public class Demo33 extends DemoBase {
    /**
     * [5, 7, 6, 9, 11, 10, 8]
     * 利用后续遍历中根节点处理最后，进行递归遍历
     */
    @Test
    public void test(){
        int [] data = new int[]{5, 7, 6, 9, 11, 10, 8};
        boolean result = isLasterOrder(data, 0, data.length - 1);
        int [] data1 = new int[]{7, 4, 6, 5};
        System.out.println(result);
        boolean lasterOrder = isLasterOrder(data1, 0, data1.length - 1);
        System.out.println(lasterOrder);
    }

    private boolean isLasterOrder(int[] data, int start, int end) {
        if (null == data || data.length == 0){
            return false;
        }
        if (start == end) {
            return true;
        }
        Integer inIndx = getInIndex(data,start, end);
        if (null == inIndx){
            return false;
        }
        boolean lasterOrderLeft = isLasterOrder(data, start, inIndx);
        boolean lasterOrderRight = isLasterOrder(data, inIndx + 1, end - 1);
        return lasterOrderLeft && lasterOrderRight;
    }

    /**
     * 获得递归分界线
     * @param data
     * @param start
     * @param end
     * @return
     */
    private Integer getInIndex(int[] data, int start,int end) {
        for (int i = end - 1; i>=start; i--) {
            if (data[i] < data[end]) {
                return i;
            }
        }
        return null;
    }
}
