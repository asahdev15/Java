package xdatastructures.stacks;

import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args){
        int[][] arr = {{0,0,0},{0,1,1}};
        floodFill(arr, 1,1,1);
        System.out.println(Arrays.deepToString(arr));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]!=newColor)
            floodFill2(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public static int[][] floodFill2(int[][] image, int sr, int sc, int newColor, int c) {
        if(image[sr][sc]!=c)
            return image;

        image[sr][sc] = newColor;

        if(sr+1<image.length && image[sr+1][sc]==c)
            floodFill2(image, sr+1, sc, newColor, c);
        if(0<=sr-1 && image[sr-1][sc]==c)
            floodFill2(image, sr-1, sc, newColor, c);
        if(sc+1<image[sr].length && image[sr][sc+1]==c)
            floodFill2(image, sr, sc+1, newColor, c);
        if(0<=sc-1 && image[sr][sc-1]==c)
            floodFill2(image, sr, sc-1, newColor, c);
        return image;
    }
}
