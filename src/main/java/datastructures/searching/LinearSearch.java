package datastructures.searching;

public class LinearSearch {

    static public class DataSet {
        int[] data;
        int NumberTry;

        public DataSet(int size) {
            data = new int[size];
            for (int i = 1; i <= size; i++)
                data[i - 1] = i;
            NumberTry = 0;
        }

        public int getSize() {
            return data.length;
        }
    }

    public static void main(String[] args) {
        DataSet data = new DataSet(1000000);
        int Search = 999999;
        Boolean IsFound = false;
        for (int i = 0; i < data.getSize(); i++) {
            data.NumberTry++;
            if (data.data[i] == Search) {
                System.out.println("Number is found after " + data.NumberTry + "  try");
                IsFound = true;
                break;
            }
        }
        if (IsFound == false) {
            System.out.println("Number is not found");
        }
    }

}