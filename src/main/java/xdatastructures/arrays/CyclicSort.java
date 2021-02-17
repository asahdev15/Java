package xdatastructures.arrays;

class CyclicSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 1, 5, 6, 4, 3, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void sort(int[] nums) {
        for(int i=1; i<nums.length; i++){
            while(nums[i-1]!=i){
                int tmp = nums[i-1];
                nums[i-1] = nums[tmp-1];
                nums[tmp-1] = tmp;
            }
        }
    }



}