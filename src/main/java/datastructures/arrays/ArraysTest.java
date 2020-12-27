package datastructures.arrays;

import java.util.Arrays;

public class ArraysTest {

    public static void main(String[] args){
        int[] myArray1 = {-1,-1,-1,0,1,1};
        System.out.println(pivotIndex(myArray1));
    }

    public static int pivotIndex(int[] nums) {
        int N = nums.length;
        if(N>2){
            int[] sum = new int[N];
            sum[0]=nums[0];
            for(int i=1; i<=N-1; i++){
                sum[i]=sum[i-1]+nums[i];
            }
            System.out.println(Arrays.toString(sum));
            for(int i=1; i<=N-2; i++){
                if(sum[i-1]==(sum[N-1]-sum[i])){
                    return i;
                }
            }
        }
        return -1;
    }

}
