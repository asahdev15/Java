package xdatastructures.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Intersection {
    public static void main(String[] args){

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1)
            set1.add(n);

        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2)
            set2.add(n);

        set1.retainAll(set2);

        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1)
            output[idx++] = s;
        return output;
    }
}
