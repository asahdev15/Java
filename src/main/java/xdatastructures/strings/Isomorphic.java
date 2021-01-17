package xdatastructures.strings;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;

        Map<Character, Character> mp = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            Character a = s.charAt(i);
            Character b = t.charAt(i);
            if((mp.containsKey(a) || mp.values().contains(b)) && mp.get(a)!=b)
                return false;
            mp.put(a, b);
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;

        int[] sc = new int[256];
        int[] tc = new int[256];
        for(int i = 0; i < s.length(); i++){
            char scc = s.charAt(i);
            char tcc = t.charAt(i);
            if(sc[scc]!=tc[tcc])
                return false;

            sc[scc]=i+1;
            tc[tcc]=i+1;
        }

        return true;
    }
}
