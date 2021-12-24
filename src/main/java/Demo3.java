import java.util.stream.IntStream;

/**
 * @author liuzihao
 * @create 2021-10-25-16:07
 */
public class Demo3 {
    public static void main(String[] args) {
        Demo111 demo111 = new Demo111();

        int[] prices = {578, 600, 348, 1178, 1244, 1677, 1248, 1469, 1311};
        System.out.println(demo111.getTotal(prices));

        IntStream.rangeClosed(0,1000).forEach(i-> System.out.println(i));

        //IntStream.range(0,1000).forEach(i-> System.out.println(i));


    }
}

class Demo111 {
    int buy = 0;
    int tmp;

    public int getTotal(int arr []) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int total = 0;

        // 买点
        while ((tmp = findBuy(buy, arr)) != -1) {

            // 卖点
            int shop = findShop(tmp, arr);

            // 总收益
            total += arr[shop] - arr[buy];

            buy = shop + 1;

            if(buy == arr.length -1) {
                break;
            }
        }
        return total;
    }

    /**
     * 找买点
     *
     * @param index
     * @return
     */
    public static int findBuy(int index, int [] arr) {
        for (int i = index; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }
    /**
     * 找卖点
     *
     * @param index
     * @return
     */
    public static int findShop(int index, int [] arr ) {
        for (int i = index; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }

}
