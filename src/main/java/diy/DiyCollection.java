package diy;

import java.util.Arrays;
/**
 * @author hao
 * @create 2019-07-15 ${TIM}
 */
public class DiyCollection {

    //元素个数
    private int size;

    //数组存储
    private Object elementData [];

    //默认初始容量
    private final static int  DEFAULT_CAPACITY = 10;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < this.size; i++) {
            stringBuilder.append(elementData[i]+",");
        }
        stringBuilder.setCharAt(stringBuilder.length()-1,']');

        return stringBuilder.toString();
    }


    public DiyCollection(){
        this.elementData = new Object [DEFAULT_CAPACITY];
    }

    // add方法
    public void add(Object o){
        ensureCapacity(this.size+1);  // 检查扩容
        elementData[size++] = o;    //添加元素
    }

    /**
     * 移除元素操作
     * @param index
     */
    public void remove(int index){
        int movestart = index + 1;
        int movenums = elementData.length - movestart;
        if (movenums >0)
            System.arraycopy(elementData,movestart,elementData,index,movenums);
        //移除
        elementData[--size] = null;
    }
    //get方法
    public  Object get(int index){
        if(index >= size) throw new ArrayIndexOutOfBoundsException("越界");
        return elementData[index];
    }

    private void ensureCapacity(int size){
        if(size > this.elementData.length ){ //判断预期容量是否足够
            //扩容操作
            capacity();
        }
    }


    private void capacity(){
        //新长度
        int newLength = this.elementData.length + (this.elementData.length>>1);
        //底层还是使用  System.arraycopy方法
        elementData = Arrays.copyOf(this.elementData, newLength);
    }


    public static void main(String[] args) {
        DiyCollection diyCollection = new DiyCollection();
        for (int i = 0; i <20 ; i++) {
            diyCollection.add((char)(i+'A'));
        }
        diyCollection.remove(4);
        diyCollection.remove(5);
        System.out.println(diyCollection);

    }
}
