package Test;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author hao
 * @create 2019-07-11 ${TIM}
 */
public class DemoTest {


    @Test
    public void test(){
        System.out.println(String.valueOf("adbcefg".toCharArray(),1,3));
        int [] arr ={1,2,3,4,5,};
        int [] arr2 ={1,2,3,4,5,};
        List<int[]> ints = Arrays.asList(arr);
        List<int[]> ints1 = new ArrayList<>(ints);
        ints1.add(arr2);
        System.out.println(arr);
    }

    //冒泡排序 稳定 从小到大 像泡泡一样往上升 选出大的
    @Test
    public void test2(){
        int temp ;
        int [] arr ={8,6,5,4,1,10,3};
        for (int i =0 ; i<arr.length-1;i++){
            for (int j = 0 ; j<arr.length -i-1;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //选择排序 不稳定 选出小的（从小到大）
    @Test
    public void test3(){
        int temp ;
        int [] arr ={8,6,5,4,1,10,3};
        int min ;
        //8,6,5,4,1,10,3
        //第一次 从 8 [6,5,4,1,10,3]  进行循环只要比第一位小 那么就进行交换
        for (int i= 0;i< arr.length-1;i++){
            for(int j = i+1; j<arr.length;j++){
                if(arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
    
    //改进选择
    @Test
    public void test5(){
        int [] arr = {1,2,7,9,3,4,5};
        int temp ;
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;//假定最小的角标
            for (int j = i + 1 ; j < arr.length ; j++) {
                //  获得小的元素的脚标
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            if (arr[i] > arr [minIndex]){ 
                temp =  arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            //否则 minindex就是最小位置
        }

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){
        int [] arr = {1,2,3};
        int target = 5;

        int[] ints = twoSum(arr, target);
        System.out.println(Arrays.toString(ints));

    }


    // 力扣第一题求和
    public int[] twoSum(int[] nums, int target) {
        int a = 0;
        int [] result = new int [2];
        boolean flag = true;
        for(int i = 0;i<nums.length-1&&flag;i++){
            for(int j = i+1; j<nums.length;j++){
                a = nums[i]+nums[j];
                if(a==target){
                    result[0] = i;
                    result[1] = j;
                    flag = false;
                    break;
                }
            }
        }
        return result;
    }

    @Test
    public void test6() throws Exception {

        Map <String,Object> map = new HashMap<>();
        Class<? extends Map> mapcalss = map.getClass();

        Field size = mapcalss.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size:   "+size.get(map));

        Method capacity = mapcalss.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity  :"+capacity.invoke(map));
    }

    @Test
    public void test7(){
        System.out.println(-1>>>1);
    }

    @Test
    public void testLinkedHashMap(){
        String s1 = new String("1")+1;
        String s2 = "11";
        System.out.println(s1==s2);
    }

    @Test
    public void test33(){
        try {
            int a = 1/0;
        }catch (Exception e){
        }
        System.out.println("1111111111");
    }

    @Test
    public void test333(){
        System.out.println((-4)%2);
    }
    @Test
    public void testQueue(){
        Comparator<ArrInt> comparator = new Comparator<ArrInt>() {
            @Override
            public int compare(ArrInt o1, ArrInt o2) {
                return o2.getVal()-o1.getVal();
            }
        };
        ArrInt i1 = new ArrInt(1);
        ArrInt i2 = new ArrInt(2);
        ArrInt i3 = new ArrInt(3);
        ArrInt i4 = new ArrInt(4);
        PriorityQueue<ArrInt> priorityQueue = new PriorityQueue<ArrInt>(comparator);
        priorityQueue.add(i1);
        priorityQueue.add(i2);
        priorityQueue.add(i3);
        priorityQueue.add(i4);
        System.out.println(priorityQueue.peek().getVal());
        Map<String,String> map = new HashMap<>();

    }
    @Test
    public void testArr(){
        String a = "ahgki";
        char [] b = a.toCharArray();
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));
        char [] c = {'a','g','h','i','k'};
        System.out.println(Arrays.equals(b, c));
        Map<String,Integer> tMap = new HashMap<String,Integer>();
        tMap.put('c'+"",1);
        for (Map.Entry<String, Integer> stringIntegerEntry : tMap.entrySet()) {
        }
    }

    @Test
    public void test236(){
        Solution solution = new Solution();
        String a = "hhbywxfzydbppjxnbhezsxepfexkzofxyqdvcgdvgnjbvihgufvgtuxtpioxgjuwawkbaerbsirrktcjcesepcocaglbassivfbjhikynfsvlbtkawstrclbkpuldshfgfvwjawownulsggsxhhqglbhjlgltfrqyjntgldlgorgatnjrsywlyngxrcwfojkmydmjbzuquqnzbpwlcbdzgdicctpkgtbdjgywkyrkityvohjbuvmzdfyicyplmrpygdhaeqbuxnehfybsysnnmzbhprsyjmtpcrzeqqbirofzjtlsyofdyeffkvpuhzaflwjfhnsuyryetjuajjnjwvlvrhvpenaarnzoafztixjrisfzdlepcwhxudjpsiirtofymnovacjmpdjtethjqfwduekczlqhsfjgqesyoxcfooagrdhyvsmssbhsclnlblhobvhwtpyftolneozlhbtjagpgqnnapktyevdvjfwdnbwsbelweoflhyhifprieuvfcdkavqxkygjlaegqfmzndgxbsccjgpclxmlpstrqjtqyvlqcopnahqvnpvkjimfdlosvletmamqjvotqwhadutmfvlgldniixvdkmymfadckuaglgbuttymoqmzkaeqxugsrnfyxzcamwxujgzupefretsvbdweuwwcizjvhcowtmwgkdafcpzctpsjwdocgofivyshwdinbdhbxdfhjsrrsfchxkeqndgzauyprwfnrbmunanqnhmjhrufoinakwaciaoerioqffmipfqujfxwofqdyjbhagkyvmnxcwomgnmwlaodxgkgthnuctoozxrebjiynjwohtgukyneyofabpfdrxklopmxxiwjuxqpaazknscagfiaetmmwnwpzceglupqvlctywtpluoqbzdultcsudubqclbwlxyfboimfwriugfulbntvdwnxgiycxvennakpodorvpiknkridcumsovvfziki";
        String b =  "rmhdxtymfgxjluxmeeerhxrrtjgecmyfdhevakyosvvuwgbwmxiakbmtqjjpgctjojdqatuelqmfeldgoprxbzcylajhhjngqlmporofjpoyhrkptrbpzvvnkrqjovfzmmqybqxzjxarhguqcyvlugwmnzwtffanzuajraqbvjflgalgcwuhmrkblobybwouffzptbvkmwoklczfhvkqsirkqvhkryyxpkyfnwnjudvllmznupldkpoplwdlfzncwxdlgvgkehpcudqybnyhofpjnjmahnsrntxjtgocwsrnukejehwzxdetglgahdvzyypdztqwbnfrnytxprhtqjgobzjyewuasgnryjoyvwhdmemppixqcowgmicbmsukgodwgnsdieuqyzuysedmsphmritlqtnvnvfnmgnghxdsmmnzdhdalhfsfsppupteyrlajxrlbyqteaytgpsckottqnibbxhmkwuqfftwvibzsnaumsbohxeoaulsmwuvjcimscyqhtioekembdwfozglussscbzejqnvmcpfwdmxshhrkquacplctruyklkxcfovcbqllmyghdbkhdmawpmalrsgymgmbleftwtvldxkqprcbcbneyyluoyydtcvkimqjoinwntfxfbwqjbufqansdlgrgauzfwxpzrjxpesmozcsczbfzfeziedqzwywtxhyfnpbxfgbqcsfwdiplegcsrseqsagvkpjrupkaxffrddebpntocmkbarvdrhvujedwnktsdimzcbqlqyizozxcexqpoefjpznegsrtbfanqdyqaaudcklplvxojfuzccmtauaxurbwbexulqbxooadcrlxbtggxcycadratsuqavwwkdqtutptdpbnxeicmackhyvjhkfbayjmymjwejybhoryyqjjmwqzhpgulovxaccychffcplvkqfqghmgmdsigkugsevwkvzgpxiolhtzocdiphokfitgg";
        System.out.println(solution.isAnagram(a,b));
    }

    @Test
    public void testFun(){
        System.out.println(funSum(3));
    }
    int funSum(int n){
        if(n==0||n==1) {
            return  n;
        }else {
            return n+funSum(n-1);
        }
    }
    class ArrInt{
       private Integer val;

        public ArrInt(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }
    }

    @Test
    public void test3Arr(){
        int []  a = {2,1,3};
        int [] b = {1,3,2};
        Arrays.sort(a);
        Arrays.sort(b);
        Set<int [] > set = new HashSet<>();
        set.add(a);
        set.add(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(set.size());

    }


    // x是N次幂
    public double myPow(double x, int n) {
        //递归出口
        if(n==1) {
            return x;
        }else if(n==-1){
            return 1/x;
        }
        //x为偶数

        if (n%2==0){
            return myPow(x,n/2)*myPow(x,n/2);
        }else{
         //y是基数
            return x*myPow(x,(n-1)/2)*myPow(x,(n-1)/2);
        }


        //x为奇数

    }
    class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            // 使用set 存储 然后获取 然后遍历返回 时间复杂度O(N)
            int tar1 = 0;
            int tar2 = 0;
            int [] result = new int [2];
            Set<Integer> set = new HashSet<Integer>();
            for( int num :nums){
                set.add(num);
            }
            for(int num : nums){
                if(num == target-num){
                    continue;
                }
                if(set.contains(target - num)){
                    tar1 = num;
                    tar2 = target - num;
                    break;
                }
            }
            for(int i = 0;i<nums.length;i++){
                if(nums[i]==tar1){
                    result[0] = i;
                }
                if(nums[i]==tar2){
                    result[1] = i;
                }
                if(result[1]!=0){
                    return result;
                }
            }

            return  new int[] {};
        }
    }
    class Solution {
        public boolean isAnagram(String s, String t) {
            if(s==null||t==null){
                return false;
            }
            if(s.length()!=t.length()){
                return false;
            }
            Map<Character,Integer> sMap = new HashMap<Character,Integer>();
            Map<Character,Integer> tMap = new HashMap<Character,Integer>();
            logCount(sMap,s);
            logCount(tMap,t);
           int [] a = new int []{};
            //对比是否相同
            return isEquals(sMap,tMap);
        }

        void logCount(Map<Character,Integer> map,String s){
            for(char c :s.toCharArray()){
                if(map.get(c)==null){
                    map.put(c,1);
                }else{
                    map.put(c,map.get(c)+1);
                }
            }
        }

        boolean isEquals(Map<Character,Integer> map,Map<Character,Integer> map2){
            if(map.size()!=map2.size()){
                return false;
            }
            for(Map.Entry<Character, Integer> st:map.entrySet()){
                if(st.getValue()!=map2.get(st.getKey())){
                    return false;
                }
            }
            return true;
        }
    }
}
