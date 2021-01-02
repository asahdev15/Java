package collections;

import java.util.Arrays;
import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
//        Stack<String> s = new Stack<String>();
//        s.push("A");
//        s.push("B");
//        s.push("C");
//        System.out.println(s.isEmpty());
//        System.out.println(s);
//        System.out.println(s.peek());
//        System.out.println(s);
//        System.out.println(s.pop());
//        System.out.println(s);

        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));

    }

    public static int[] dailyTemperatures(int[] T) {

        int[] d = new int[T.length];
        Stack<Integer> temps = new Stack<>();

        for(int i=T.length-1; i>=0; i--){
            int ct = T[i];
            if(temps.isEmpty()){
                temps.push(ct);
            }else{
                Stack<Integer> pushback = new Stack<>();
                while(!temps.isEmpty()){
                    int val = temps.pop();
                    pushback.push(val);
                    if(val>ct){
                        d[i]=pushback.size();
                        break;
                    }
                }
                while(!pushback.isEmpty()){
                    temps.push(pushback.pop());
                }
                temps.push(ct);
            }
        }
        return d;
    }

}

/*

[73,74,75,71,69,72,76,73]
                    i
[0,0,0,0,0,0,0,0]


73 -


 */