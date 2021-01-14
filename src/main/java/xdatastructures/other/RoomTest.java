package xdatastructures.other;

import java.util.*;

public class RoomTest{
    
    private static Scanner sc = null ;
    
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            run();
            t--;
        }
    }
    
    private static void run(){
        int[][] rooms = buildRooms();
        int callCount = 0;
        int m = rooms.length;
        int n = rooms[0].length;
        int i = 0;

        while(i<m){
            int j = 0;
            while(j<n){
                int isOne = rooms[i][j];
                if(isOne == 1){
                    checkNearByRooms(rooms, i, j, m, n);
                    // if it is one, then check adjscent rooms and make them 0;
                    callCount++;
                }
                j++;
            }
            i++;
        }
        System.out.println(callCount);
    }
    
    
    private static void checkNearByRooms(int[][] rooms, int i, int j, int m, int n){
        if( i>=0 && i<m && j>=0 && j<n && rooms[i][j] == 1){
            rooms[i][j]=0;
            // left
            checkNearByRooms(rooms, i, j-1, m, n);
            // right
            checkNearByRooms(rooms, i, j+1, m, n);
            // top
            checkNearByRooms(rooms, i-1, j, m, n);
            // bottom
            checkNearByRooms(rooms, i+1, j, m, n);
            // diag left top
            checkNearByRooms(rooms, i-1, j-1, m, n);
            // diag left bottpom
            checkNearByRooms(rooms, i+1, j-1, m, n);
            // diag right top
            checkNearByRooms(rooms, i-1, j+1, m, n);
            // diag right bottom
            checkNearByRooms(rooms, i+1, j+1, m, n);
        }
    }
    
    private static int[][] buildRooms(){
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] rooms = new int[m][n];
        int i = 0;
        while(i<m){
            int j = 0;
            while(j<n){
                rooms[i][j]=sc.nextInt();
                j++;
            }
            i++;
        }
        return rooms;
    }
    
}
