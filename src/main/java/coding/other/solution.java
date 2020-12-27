package coding.other;

import java.awt.peer.SystemTrayPeer;
import java.util.*;

class solution {



    private static Scanner sc;

    static char[] base64Arr = new char[64];


    public static void main(String[] args) {
        initializeBase64Arr();
        runSolution();
    }

    private static void step1(char[] check){
        int allCharSum = 0;
        for(int i = check.length-1 ; i >=0 ; i--){
            char a1 = check[i];
            int d1 = getCharBase64Index(a1) * 2 ;
            if( d1 >= 64){
                d1 = d1 - 64;
                d1 = 1 + d1;
                System.out.println("Converted : " + a1 + ":" + base64Arr[d1]);
            }
            System.out.println("Adding : " + a1 + ":" + d1);
            allCharSum+=d1;
            i--;
            if(i>=0){
                char a2 = check[i];
                int d2 = getCharBase64Index(a2);
                allCharSum+=d2;
                System.out.println("Adding : " + a2 + ":" + d2);
            }
        }
        System.out.println(allCharSum);
        int newIdx = allCharSum;
        if(allCharSum > 0){
            newIdx = 64-(allCharSum%64);
        }
        if (allCharSum == 64) {
            newIdx--;
        }
        System.out.println(newIdx);
        System.out.println(base64Arr[newIdx]);
    }

    private static int getCharBase64Index(char input){
        for(int i = 0 ; i <= 64 ; i++){
            if(base64Arr[i] == input){
                return i;
            }
        }
        return -1;
    }

    private static void initializeBase64Arr(){
        int alpha = 'A';
        for(int i = 0 ; i <= 25 ; i++){
            base64Arr[i] = (char)alpha;
            alpha++;
        }
        alpha = 'a';
        for(int i = 26 ; i <= 51 ; i++){
            base64Arr[i] = (char)alpha;
            alpha++;
        }
        alpha = '0';
        for(int i = 52 ; i <= 61 ; i++){
            base64Arr[i] = (char)alpha;
            alpha++;
        }
        base64Arr[62] = '+';
        base64Arr[63] = '/';
    }

    private static void runSolution(){
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int n = 0; n < t; n++) {
            runTest();
        }
    }

    private static void runTest(){
        int a = sc.nextInt();
        String b = sc.next();
        char[] check = b.toCharArray();
//        System.out.println(a + " - "+ b);
        step1(check);


    }
}