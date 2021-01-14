package xdatastructures.arrays;

import java.util.HashMap;
import java.util.Map;

public class JumpEnd {

    public static void main(String[] args) {
        JumpEnd test = new JumpEnd();
        System.out.print(test.canJump(new int[]{3,2,1,0,4}));
    }

    private Map<Integer, Boolean> dp = new HashMap<>();

    public boolean canJump(int[] nums) {
        return reaches(nums, 0);
    }

    // O(n) - Optimized
    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    // O (n) - Optimized
    public boolean canJump3(int[] nums) {
        if (nums.length <= 1)
            return true;

        for (int pos = nums.length - 2; pos >= 0; pos--) {
            if (nums[pos] == 0) {
                int neededJumps = 1;

                while (neededJumps > nums[pos]) {
                    neededJumps++;
                    pos--;

                    if (pos < 0)
                        return false;
                }
            }
        }
        return true;
    }

    private boolean reaches(int[] nums, int curIndex){
        if(curIndex == nums.length-1){
            return true;
        }
        if(dp.containsKey(curIndex)){
            return dp.get(curIndex);
        }
        boolean reached = false;
        int k = nums[curIndex];
        if(k > (nums.length-1 - curIndex)){
            k = nums.length-1 - curIndex;
        }
        for(int i = k ; i >= 1 ; i--){
            int newIndex = curIndex+i;
            if(newIndex == nums.length-1){
                reached = true;
            }
            else if(newIndex < nums.length-1){
                reached = reaches(nums, newIndex);
            }
            if(reached){
                break;
            }
        }
        dp.put(curIndex, reached);
        return reached;
    }

}
