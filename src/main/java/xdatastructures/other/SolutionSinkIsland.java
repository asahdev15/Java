package xdatastructures.other;

import java.util.Scanner;

public class SolutionSinkIsland {

    // scanner
    // get inputs
    // build array from inputs
    // get no. of islands
    // 1 represent land
    // 0 represent water
    // return toal island present in array
    // island is a grouhp of 1 together with up down right left

    // algo
    // DFS or BFS
    // and makr 1 as 0 for earch 1
    // increment islandCount ++1

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int n = 0; n < t; n++) {
            runTest();
        }
    }


    private static void runTest(){
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] input = new int[r][c];
        for(int i = 0 ; i<r ; i++){
            for(int j = 0 ; j<c ; j++){
                input[i][j] = scanner.nextInt();
            }
        }
        System.out.println(countIslands(r,c,input));
    }

    private static int countIslands(int r, int c, int[][] arr){
        int count = 0;
        for(int i = 0 ; i<r ; i++){
            for(int j = 0 ; j<c ; j++){
                if(arr[i][j]==1){
                    sinkIsland(r,c,arr,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void sinkIsland(int r, int c, int[][] arr, int i, int j){
        if(arr[i][j]==1){
            arr[i][j]=0;
        }else{
            return;
        }
        // r
        if(i+1 < r){
            sinkIsland(r, c, arr, i+1, j);
        }
        // l
        if(i-1 >= 0){
            sinkIsland(r, c, arr, i-1, j);
        }
        // u
        if(j+1 < c){
            sinkIsland(r, c, arr, i, j+1);
        }
        // d
        if(j-1 >= 0){
            sinkIsland(r, c, arr, i, j-1);
        }
    }


}
