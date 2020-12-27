package datastructures.searching;


public class BinarySearch2 {


    public static void main(String[] args) {

//        System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
//        System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
//        System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
//        System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
//
//        System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
//        System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
//        System.out.println(searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
//        System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 17));


//        System.out.println(findMaxBitonicIncDec(new int[] { 1, 3, 8, 12, 4, 2 }));
//        System.out.println(findMaxBitonicIncDec(new int[] { 3, 8, 3, 1 }));
//        System.out.println(findMaxBitonicIncDec(new int[] { 1, 3, 8, 12 }));
//        System.out.println(findMaxBitonicIncDec(new int[] { 10, 9, 8 }));
        
    }


    public static int search(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        boolean isAscending = arr[start] < arr[end];
        while (start <= end) {
            // calculate the middle of the current range
            int mid = start + (end - start) / 2;

            if (key == arr[mid])
                return mid;

            if (isAscending) { // ascending order
                if (key < arr[mid]) {
                    end = mid - 1; // the 'key' can be in the first half
                } else { // key > arr[mid]
                    start = mid + 1; // the 'key' can be in the second half
                }
            } else { // descending order
                if (key > arr[mid]) {
                    end = mid - 1; // the 'key' can be in the first half
                } else { // key < arr[mid]
                    start = mid + 1; // the 'key' can be in the second half
                }
            }
        }
        return -1; // element not found
    }

    public static int searchCeilingOfANumber(int[] arr, int key) {
        if (key > arr[arr.length - 1]) // if the 'key' is bigger than the biggest element
            return -1;

        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else { // found the key
                return mid;
            }
        }
        // since the loop is running until 'start <= end', so at the end of the while loop, 'start == end+1'
        // we are not able to find the element in the given array, so the next big number will be arr[start]
        return start;
    }

    public static int searchFloorOfANumber(int[] arr, int key) {
        if (key < arr[0]) // if the 'key' is smaller than the smallest element
            return -1;

        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else { // found the key
                return mid;
            }
        }
        // since the loop is running until 'start <= end', so at the end of the while loop, 'start == end+1'
        // we are not able to find the element in the given array, so the next smaller number will be arr[end]
        return end;
    }

    public static char searchNextLetter(char[] letters, char key) {
        int n = letters.length;
        if (key < letters[0] || key > letters[n - 1])
            return letters[0];

        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < letters[mid]) {
                end = mid - 1;
            } else { //if (key >= letters[mid]) {
                start = mid + 1;
            }
        }
        // since the loop is running until 'start <= end', so at the end of the while loop, 'start == end+1'
        return letters[start % n];
    }

    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[] { -1, -1 };
        result[0] = searchRange(arr, key, false);
        if (result[0] != -1) // no need to search, if 'key' is not present in the input array
            result[1] = searchRange(arr, key, true);
        return result;
    }

    // modified Binary Search
    private static int searchRange(int[] arr, int key, boolean findMaxIndex) {
        int keyIndex = -1;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else { // key == arr[mid]
                keyIndex = mid;
                if (findMaxIndex)
                    start = mid + 1; // search ahead to find the last index of 'key'
                else
                    end = mid - 1; // search behind to find the first index of 'key'
            }
        }
        return keyIndex;
    }

    static int binarySearchRec(int[] a, int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) / 2);
        if (a[mid] == key) {
            return mid;
        } else if (key < a[mid]) {
            return binarySearchRec(a, key, low, mid - 1);
        } else {
            return binarySearchRec(a, key, mid + 1, high);
        }
    }

    public static int searchMinDiffElement(int[] arr, int key) {
        if (key < arr[0])
            return arr[0];
        if (key > arr[arr.length - 1])
            return arr[arr.length - 1];

        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return arr[mid];
            }
        }

        // at the end of the while loop, 'start == end+1'
        // we are not able to find the element in the given array
        // return the element which is closest to the 'key'
        if ((arr[start] - key) < (key - arr[end]))
            return arr[start];
        return arr[end];
    }

    public static int findMaxBitonicIncDec(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        // at the end of the while loop, 'start == end'
        return arr[start];
    }

    class ArrayReader {
        int[] arr;

        ArrayReader(int[] arr) {
            this.arr = arr;
        }

        public int get(int index) {
            if (index >= arr.length)
                return Integer.MAX_VALUE;
            return arr[index];
        }
    }

    public static int search(ArrayReader reader, int key) {
        // find the proper bounds first
        int start = 0, end = 1;
        while (reader.get(end) < key) {
            int newStart = end + 1;
            end += (end - start + 1) * 2; // increase to double the bounds size
            start = newStart;
        }
        return binarySearch(reader, key, start, end);
    }

    private static int binarySearch(ArrayReader reader, int key, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < reader.get(mid)) {
                end = mid - 1;
            } else if (key > reader.get(mid)) {
                start = mid + 1;
            } else { // found the key
                return mid;
            }
        }
        return -1;
    }
}
