package coding.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Permutation {

    public static void main( String args[] ) {

        Set<String> result = getPermutations("cats");
        System.out.println(result);

//        char[] array = new char[] { 'a', 'b', 'c', 'd' };
//        char[] perm = new char[array.length];
//        boolean[] used = new boolean[256];
//        permute(array, perm, 0, used);
    }

    static void permute(char[] array, char[] perm, int i, boolean[] used) {

        // base case
        if (i == perm.length) {
            System.out.println(perm);
            return;
        }

        for (int j = 0; j < array.length; j++) {

            if (!used[array[j] - 'a']) {
                perm[i] = array[j];
                used[array[j] - 'a'] = true;
                permute(array, perm, i + 1, used);
                used[array[j] - 'a'] = false;
            }
        }
    }

    static Map<String, Set<String>> memo = new HashMap();
    public static Set<String> getPermutations(String inputString) {
        Set<String> result = new HashSet<>();
        // base
        int len = inputString.length();
        if(len <=1 ){
            result.add(inputString);
            return result;
        }
        // memo
        if(memo.containsKey(inputString)) {
            return memo.get(inputString);
        }
        for(int i = 0 ; i < len; i++){
            String subStr = "";
            if(i==0){
                subStr = inputString.substring(1);
            }else{
                subStr = inputString.substring(0, i) + inputString.substring(i+1, len);
            }
            Set<String> r1 = getPermutations(subStr);
            for(String item : r1){
                result.add(inputString.charAt(i)+item);
            }
        }
        memo.put(inputString, result);
        return result;
    }

}
