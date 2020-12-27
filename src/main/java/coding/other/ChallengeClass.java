package coding.other;

class ChallengeClass {

//    public static void main( String args[] ) {
//        String input1 = "Helloo";
//        String input2 = "Thiss iiss aa teesstt";
//
//        System.out.println( "Original string: " + input1);
//
//        String output = remDuplicates(input1);
//
//        System.out.println("String after: " + output);
//    }

    private static String remDuplicates(String text) {
        if (text.length() == 1) {
            return text;
        }

        if (text.substring(0,1).equals(text.substring(1,2))) {
            return remDuplicates(text.substring(1));
        }
        else {
            return text.substring(0,1) + remDuplicates(text.substring(1));
        }
    }


//    public static void main( String args[] ) {
//        String string1 = "Hello World";
//        String string2 = "Reverse";
//
//        System.out.println( "The Original String is: ");
//        System.out.println(string1);
//
//        String resultStr = reverseString(string1);
//
//        System.out.println("String after reversal: ");
//        System.out.println(resultStr);
//    }


    public static String reverseString(String myStr) {
        // Base case
        if (myStr.isEmpty()) {
            return myStr;
        }

        // Recursive case
        else {
            return reverseString(myStr.substring(1)) + myStr.charAt(0);
        }
    }


//    public static void main( String args[] ) {
//        String one = "adz";
//        String two = "bfx";
//        String answer = alphabeticMerge(one, two);
//        System.out.println(answer);
//    }

    private static String alphabeticMerge(String one, String two) {
        if (one == null || one.equals("")) {
            return two==null? one:two;
        }
        else if (two == null || two.equals("")) {
            return one;
        }
        else if (two.charAt(0) > one.charAt(0)) {
            return one.charAt(0) + alphabeticMerge(one.substring(1, one.length()), two);
        }
        else {
            return two.charAt(0) + alphabeticMerge(one, two.substring(1, two.length()));
        }
    }

//    public static void main( String args[] ) {
//        String string1 = "Hello world";
//        String string2 = "STR";
//        String string3 = "AEIOUaeiouSs";
//
//        int result1 = callTotalVowels(string1);
//        int result2 = callTotalVowels(string2);
//        int result3 = callTotalVowels(string3);
//
//        System.out.println( "Total number of vowels in " + string1 + " are = " + result1);
//        System.out.println( "Total number of vowels in " + string2 + " are = " + result2);
//        System.out.println( "Total number of vowels in " + string3 + " are = " + result3);
//    }

    public static int totalVowels(String text, int len, int index) {
        int count = 0;

        if (len == 0) {
            return 0;
        }
        char single = Character.toUpperCase(text.charAt(index));
        if (single == 'A' || single == 'E' || single == 'I' || single == 'O' || single == 'U') {
            count++;
        }
        return count + totalVowels(text, len-1, index+1);
    }

    public static int callTotalVowels(String text) {
        return totalVowels(text, text.length(), 0);
    }


//    public static void main( String args[] ) {
//        char[] input = {'a', 'b', 'b', 'a'};
//        permutations(input, input.length);
//    }

    public static void permutations(char[] array, int length) {
        if (length == 1) {
            System.out.println(array);
            return;
        }
        else {
            for (int i = 0; i < length; i++) {
                swap(array, i, length-1);
                permutations(array, length-1);
                swap(array, i, length-1);
            }
        }
    }

    public static void swap(char[] array, int i, int j) {
        char c;
        c = array[i];
        array[i] = array[j];
        array[j] = c;
    }


//    public static void main( String args[] ) {
//        String input1 = "hello";
//        String input2 = "dadad";
//        boolean answer1 = isPalindrome(input1);
//        boolean answer2 = isPalindrome(input2);
//        System.out.println("Is " + input1 + " a Palindrome? = " + answer1);
//        System.out.println("Is " + input2 + " a Palindrome? = " + answer2);
//    }

    public static boolean isPalindrome(String text) {
        if (text.length() == 0) {
            return false;
        }
        else if (text.length() == 1) {
            return true;
        }
        else {
            if (text.charAt(0) == text.charAt(text.length()-1)) {
                return isPalindrome(text.substring(1, text.length()-1));
            }
        }
        return false;
    }

}