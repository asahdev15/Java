package xdatastructures.arrays;

public class Matrix {

    public static void main(String args[]) {

        int[][] arr =
                {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
                };

        boolean found = searchMatrix(arr, 100);
        System.out.print(found);

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows > 0){
            int cols = matrix[0].length;
            for (int r = 0, c = cols - 1; r < rows && c >= 0; ) {
                int val = matrix[r][c];
                if(val == target){
                    return true;
                }
                if (target < val) {
                    c--;
                } else{
                    r++;
                }
            }
        }
        return false;
    }

}
