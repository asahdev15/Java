package xalgorithms.searching;

public class BinarySearch {

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
        int low = 0;
        int high = data.getSize() - 1;
        int mid = 0;
        while (!IsFound) {
            if (low > high) {
                System.out.println("number is not found");
                break;
            }
            mid = low + ((high - low) / 2);
            data.NumberTry++;
            if (data.data[low] == Search || data.data[high] == Search || data.data[mid] == Search) {
                System.out.println("number is found after " + data.NumberTry + " try");
                break;
            }
            if (data.data[mid] < Search)
                low = mid + 1;
            if (data.data[mid] > Search)
                high = mid - 1;

        }
    }

}