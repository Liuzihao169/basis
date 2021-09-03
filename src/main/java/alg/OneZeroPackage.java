package alg;

/**
 * @author liuzihao
 * @create 2021-06-06-20:59
 */
public class OneZeroPackage {
    static int totalweight= 150;
    static int N= 5;
    static int values[] = {60, 20, 10, 60, 100};
    static int weights[] = {20, 30, 50, 60, 80};

    public static void main(String[] args) {
        System.out.println(bagProblem(N-1,totalweight));
        bag01();
    }


    /**
     * 递归实现
     *   i {处理到第i件物品} , j{剩余的空间为j}
      */
    public static int bagProblem(int i, int j) {

        int r = 0;
        if(i==-1){
            return 0;
        }
        //如果剩余空间大于所放的物品
        if (j>=weights[i]){
            //放第i件
            int r1 = bagProblem(i-1,j-weights[i]) + values[i];
            //不放第i件
            int r2 = bagProblem(i-1,j);
            r = Math.max(r1,r2);
        }
        return r;

    }
    //非递归
    public static void  bag01(){
        int f[] = new int[totalweight+1];
        for (int f1:f){
            f1 = 0;
        }
        for (int i=0;i<N;i++){
            int w = weights[i];
            int v = values[i];
            for (int j= totalweight;j>=w;j--){
                f[j] = Math.max(f[j],f[j-w]+v);
            }
        }
        System.out.println(f[totalweight]);
    }

}
