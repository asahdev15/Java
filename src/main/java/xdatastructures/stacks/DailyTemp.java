package xdatastructures.stacks;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemp {
    public static void main(String[] args) {
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
