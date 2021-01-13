package xdatastructures.strings;

import org.junit.Assert;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args){

        Assert.assertEquals("abcabccdcdcdef", decodeString("2[abc]3[cd]ef"));
    }

    public static String decodeString(String s) {
        Stack<Character> cStck = new Stack<>();
        for(int i = s.length()-1 ; i>=0 ; i--){
            char c = s.charAt(i);
            if(!Character.isDigit(c)){
                cStck.push(c);
            }else{
                int n = Character.getNumericValue(c);
                int x = 1;
                while(i>0 && Character.isDigit(s.charAt(i-1))){
                    n = (Character.getNumericValue(s.charAt(i-1))*(int)Math.pow(10,x)) + n;
                    x++;
                    i--;
                }
                StringBuilder sb1 = new StringBuilder();
                cStck.pop();
                char c2 = cStck.pop();
                while(c2!=']'){
                    sb1.append(c2);
                    c2 = cStck.pop();
                }
                while(n>0){
                    for(int i2 = sb1.length()-1 ; i2>=0 ; i2--){
                        cStck.push(sb1.charAt(i2));
                    }
                    n--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!cStck.isEmpty()){
            sb.append(cStck.pop());
        }
        return sb.toString();
    }

}
