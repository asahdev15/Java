package xdatastructures.other;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
//        System.out.println(test.backspaceCompare("bxj##tw", "bxo#j##tw"));

        int[] a = {
                0,1,1,0,0,0,0,1,0,1,0,1,1,0,0,0,0,1,1,1,0,0,1,1,1,0,1,1,0,1,1,0,1,0,1,0,1,0,1,0,0,0,0,1,1,1,0,1,0,1,1,1,0,0,1,0,0,1,1,0,1,0,0,1,1,0,0,0,1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,0,0,1,0,0,0,1,0,0,0,1,1,0,1,1,0,1,1,1,1,0,1,0,0,1,0,0,1,1,0,1,1,0,1,0,0,1,0,0,1,0,1,0,0,1,0,1,1,0,1,0,0,0,1,0,1,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,1,1,0,0,0,0,0,0,1,1,1,1,1,0,1,0,0,1,0,1,0,0,0,0,1,1,1,0,1,0,0,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,0,1,0,1,0,0,1,0,1,1,1,0,0,0,0,1,1,1,0,0,1,1,1,1,1,0,1,1,0,0,1,0,1,1,0,0,1,0,1,1,1,1,0,0,0,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,0,0,1,0,1,1,0,0,0,0,0,0,0,0,1,1,1,0,0,0,1,0,0,0,0,1,0,1,0,1,1,1,0,1,1,0,1,0,1,1,0,0,0,1,0,0,0,0,0,1,0,1,0,0,1,0,0,0,1,1,0,1,1,1,0,1,1,0,1,1,0,1,1,0,1,0,0,0,0,1,1,0,1,0,1,1,0,1,0,0,1,1,0,0,0,0,1,1,0,1,1,1,0,1,0,1,1,0,0,1,0,1,0,1,0,0,1,0,1,0,0,0,1,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,1,0,1,1,0,1,0,0,1,0,1,1,0,1,0,1,1,0,1,0,0,1,0,1,0,0,1,1,1,0,1,1,1,1,0,0,1,0,1,1,1,1,0,1,1,0,1,1,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,1,1,1,0,0,1,0,0,0,0,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,1,0,1,1,0,0,0,1,1,0,0,1,0,0,1,0,1,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,0,0,1,1,0,1,1,1,0,1,1,1,0,0,0,1,1,0,1,0,1,0,0,0,0,1,1,1,0,1,1,1,1,1,0,0,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,0,0,0,0,1,0,1,0,1,1,1,0,1,1,1,0,1,0,0,1,1,1,1,1,1,0,1,0,0,0,1,0,1,1,1,1,1,0,1,1,0,0,0,1,1,1,1,0,0,0,0,1,0,1,1,0,1,1,0,1,0,1,0,0,1,1,1,1,0,1,0,0,1,0,0,0,0,1,1,1,0,1,1,0,0,0,1,0,0,1,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,1,0,1,0,1,1,1,1,0,0,1,0,1,1,1,1,0,0,0,0,1,0,1,1,1,0,0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,0,1,1,0,0,0,0,1,1,1,0,1,1,0,1,0,0,0,0,0,0,0,1,1,1,1,0,0,1,1,0,1,1,1,1,0,1,0,1,1,0,1,0,1,1,0,1,1,0,1,0,0,0,0,1,1,1,1,0,1,0,0,0,0,1,0,1,0,0,0,0,0,1,1,0,1,0,0,1,1,0,1,0,1,1,1,1,1,0,1,0,0,1,0,0,1,0,1,0,1,0,0,1,0,1,0,1,1,0,0,0,0,1,1,0,0,0,1,1,0,0,1,0,0,0,1,1,1,1,0,1,1,0,1,0,0,0,0,0,1,1,1,0,0,0,0,1,0,0,0,0,1,1,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,1,1,1,1,0,0,0,1,0,1,0,0,1,0,0,0,1

        };
        long startTime = System.currentTimeMillis();
        System.out.println(test.findMaxLength(a));
        System.out.println("Time Taken : " + (System.currentTimeMillis() - startTime));


        long startTime2 = System.currentTimeMillis();
        System.out.println(test.maxLen(a));
        System.out.println("Time Taken : " + (System.currentTimeMillis() - startTime2));

    }



    public int maxLen(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }


    public int findMaxLength(int[] nums) {
        Counter[][] dp = new Counter[nums.length][nums.length];
        for(int i = 0 ; i < nums.length ; i++)
        {
            for(int j = 0 ; j < nums.length ; j++)
            {
                dp[i][j] = new Counter();
            }
        }
        return findMax(nums, 0, nums.length-1, dp);
    }

    private int findMax(int[] nums, int i , int j, Counter[][] dp)
    {
        if(nums.length < 2)
            return 0;

        if(j-i == 1)
            return getCountEqual01(nums, i, j, dp);

        if(dp[i][j].getSize() > 0)
        {
            if(dp[i][j].getCount0() == dp[i][j].getCount1())
                return dp[i][j].getCount0() + dp[i][j].getCount1();
            return 0;
        }

        int wholeCount = getCountEqual01(nums, i, j, dp);
        int leftCount = findMax(nums, i, j-1, dp);
        int rightCount = findMax(nums, i+1, j, dp);

        int max = Math.max(Math.max(leftCount, rightCount), wholeCount);
        return max;
    }

    private int getCountEqual01(int[] nums, int i , int j, Counter[][] dp)
    {
        Counter c = getCounter(nums, i, j, dp);
        if(c.getCount0() == c.getCount1())
            return c.getCount0() + c.getCount1();
        return 0;
    }

    private Counter getCounter(int[] nums, int i , int j, Counter[][] dp)
    {
        if(dp[i][j].getSize()==0)
        {
            Counter counter = new Counter();
            counter.init();
            for(int x = i ; x <= j ; x++)
            {
                if(nums[x] == 0)
                    counter.incrementCount0();
                else
                    counter.incrementCount1();
            }
            dp[i][j] = counter;
        }
        return dp[i][j];
    }

    class Counter
    {
        public Map<Integer, Integer> cache = new HashMap();

        public int getSize()
        {
            return cache.size();
        }

        public void init()
        {
            cache.put(0,0);
            cache.put(1,0);
        }

        public int getCount0()
        {
            return cache.get(0);
        }

        public void incrementCount0()
        {
            cache.put(0, cache.get(0)+1);
        }

        public int getCount1()
        {
            return cache.get(1);
        }

        public void incrementCount1()
        {
            cache.put(1, cache.get(1)+1);
        }
    }









    private char hash = '#';

    public boolean backspaceCompare(String S, String T) {
        char[] s1 = S.toCharArray();
        char[] s2 = T.toCharArray();
        modifyString(s1);
        modifyString(s2);

        int i = getLastHashIndex(s1);
        int j = getLastHashIndex(s2);

        if(i == s1.length &&  j == s2.length)
            return true;

        while(i<s1.length || j<s2.length)
        {
            if( i == s1.length || j == s2.length || s1[i] != s2[j])
                return false;
            i++;
            j++;
        }
        return true;
    }

    private int getLastHashIndex(char[] items)
    {
        int i = 0;
        while(i < items.length && items[i] == hash)
            i++;
        return i;
    }

    private void modifyString(char[] items)
    {
        replaceHash(items);
        moveHashToLeft(items);
    }

    private void replaceHash(char[] items)
    {
        int i = 0;
        int j = 1;
        while(j < items.length)
        {
            if(items[j] == hash)
            {
                if(items[i] == hash)
                {
                    while(i>=0 && items[i]==hash)
                        i--;
                }
                if(i >= 0)
                {
                    items[i] = hash;
                    i--;
                }
            }else
                i=j;
            j++;
        }
    }

    public void moveHashToLeft(char[] items) {
        if (items.length < 1)
            return;
        int r = items.length-1;
        int w = items.length-1;
        while(r >= 0)
        {
            if(items[r] != hash)
            {
                items[w] = items[r];
                w--;
            }
            r--;
        }
        while(w >= 0)
        {
            items[w] = hash;
            w--;
        }
    }




    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a Number: ");
        String n = in.next();
        BigInteger nn = new BigInteger(n);
        if(nn.compareTo(BigInteger.ZERO)<0){
            System.out.println("Number cannot be less than 0");
        }else{
            System.out.println("Convert to binary is:");
            String str = print2Binaryform(nn);
            System.out.println("\n"+str);
        }
    }
    private static String print2Binaryform(BigInteger number) {
        String result = "";
        BigInteger reminder2;
        if(number.compareTo(BigInteger.ONE)<=0){
            result = "1";
//            System.out.print(number);
        }else{
            reminder2 = number.mod(new BigInteger(""+2));
            result = print2Binaryform(new BigInteger(""+number.divide(new BigInteger("2")))) + reminder2;
//            System.out.print(reminder2);
        }
        return result;
    }


    public static int changePossibilities(int amount, int[] denominations) {
        // calculate the number of ways to make change
        if(denominations.length == 0 || amount < denominations[0]){
            return 0;
        }
        int count = 0;
        for(int i = 0 ; i < denominations.length ; i++){
            if(amount < denominations[i]){
                break;
            }
            if(amount-denominations[i] == 0 || change(amount-denominations[i], denominations)){
                count++;
            }
        }
        return count;
    }

    private static Map<Integer, Boolean> memo = new HashMap();

    private static boolean change(int amount, int[] denominations) {
        if(amount < denominations[0]){
            return false;
        }
        if(memo.containsKey(amount)){
            return true;
        }
        boolean result = false;
        for(int n : denominations){

        }


        for(int i = 0 ; i < denominations.length ; i++){
            if(amount > denominations[i]){
                result = change(amount-denominations[i], denominations);
            }else if(amount == denominations[i]){
                result = true;
            }
        }
        memo.put(amount, result);
        return result;
    }

}
