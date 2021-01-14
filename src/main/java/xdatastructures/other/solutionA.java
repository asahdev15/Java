package xdatastructures.other;

import java.util.*;

class solutionA {

// get m n k
// build m*n [] of char
// int counter for x and o
// run 2 for loops i - j 
// check which element is it x - o
// if from that point if all elements are same -> if yes, then increment ++ that char count variable
// before traversing if size is in limits
// - horizontal check -> i,j -> k,j 
// - down vertical check -> i,j -> i,k
// - diag up right -> i,j -> i-k, j-k
// - diag down right -> i,j -> i+k, j+k
// return counts

    private static Scanner sc;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int n = 0; n < t; n++) {
            runTest();
        }
    }
    
    private static void runTest(){
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        char[][] allChars = buildAllCharsArray(m, n);
        traverseArray(m, n, k, allChars);
    }
    
    private static void traverseArray(int m, int n, int k, char[][] allChars){
        Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        charCountMap.put('x', 0);
        charCountMap.put('o', 0);
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
               char checkChar = allChars[i][j];
               int charCount = getCharCount(m, n, i, j, k, allChars, checkChar);
               charCountMap.put(checkChar, charCountMap.get(checkChar)+charCount);
            } 
        }
        System.out.println("***** " + charCountMap.get('x') + " " + charCountMap.get('o') );
    }
    
    private static int getCharCount(int m, int n, int i, int j, int k, char[][] allChars, char checkChar){
        int totalCount = 0;
        totalCount = totalCount + checkHorizontalCount(m, n, i, j, k, allChars, checkChar);
        totalCount = totalCount + checkDownVerticalCount(m, n, i, j, k, allChars, checkChar);
        totalCount = totalCount + checkDiagUpRightCount(m, n, i, j, k, allChars, checkChar);
        totalCount = totalCount + checkDiagDownRightCount(m, n, i, j, k, allChars, checkChar);
        System.out.println("----- getCharCount ; " + ", i:" + i + ", j:" + j + ", total count : "+ totalCount);
        return totalCount;
    }
    
    private static int checkDiagDownRightCount(int m, int n, int i, int j, int k, char[][] allChars, char checkChar){
        int count = 0;
        int limitRight = j + (k-1);
        int limitDown = i + (k-1);
        if(limitRight < n && limitDown < m){
            boolean increaseCount = true;
            j++;
            i++;
            while(j <= limitRight && i <= limitDown){
                if(allChars[i][j] != checkChar){
                    increaseCount = false;
                    break;
                }
                i++;
                j++;
            }
            if(increaseCount){
                count++;
            }
        }
        System.out.println("checkDiagDownRightCount - " + count);
        return count;
    }
    
    private static int checkDiagUpRightCount(int m, int n, int i, int j, int k, char[][] allChars, char checkChar){
        int count = 0;
        int limitRight = j + (k-1);
        int limitUp = i - (k-1);
        if(limitRight < n && limitUp >= 0){
            boolean increaseCount = true;
            j++;
            i--;
            while(j <= limitRight && i >= limitUp){
                if(allChars[i][j] != checkChar){
                    increaseCount = false;
                    break;
                }
                i--;
                j++;
            }
            if(increaseCount){
                count++;
            }
        }
        System.out.println("checkDiagUpRightCount - " + count);
        return count;
    }
    
    private static int checkDownVerticalCount(int m, int n, int i, int j, int k, char[][] allChars, char checkChar){
        int count = 0;
        int limit = i + (k-1);
        if(limit < m){
            boolean increaseCount = true;
            i++;
            while(i <= limit){
                if(allChars[i][j] != checkChar){
                    increaseCount = false;
                    break;
                }
                i++;
            }
            if(increaseCount){
                count++;
            }
        }
        System.out.println("checkDownVerticalCount - " + count);
        return count;
    }
    
    private static int checkHorizontalCount(int m, int n, int i, int j, int k, char[][] allChars, char checkChar){
        int count = 0;
        int limit = j + (k-1);
        if(limit < n){
            boolean increaseCount = true;
            j++;
            while(j <= limit){
                if(allChars[i][j] != checkChar){
                    increaseCount = false;
                    break;
                }
                j++;
            }
            if(increaseCount){
                count++;
            }
        }
        System.out.println("checkHorizontalCount - " + count);
        return count;
    }
    
    private static char[][] buildAllCharsArray(int m, int n){
        char[][] allChars = new char[m][n];
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                allChars[i][j] = sc.next().charAt(0);
            } 
        }
        return allChars;
    }
}