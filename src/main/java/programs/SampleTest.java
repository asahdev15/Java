package programs;

import java.util.Comparator;
import java.util.Scanner;

public class SampleTest {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCasesCount = scanner.nextInt();
        while(testCasesCount > 0){
            int inSize = scanner.nextInt();
            String arr = scanner.nextLine();
            String[] in = arr.split(" ");
            System.out.print(inSize + " ");
            System.out.print(in + " ");
            for(String item : in){
                System.out.println(item);
            }
            for(int i = 0 ; i < inSize ; i++){
    	        /*
    	        String nE = "-1";
    		    if(i<(inSize-1) && Integer.parseInt(in[i])>Integer.parseInt(in[i+1])){
    		        nE=in[i+1];
    		    }
    		    */
                System.out.print(in[i] + " ");
            }
            testCasesCount--;
        }
    }


    private static String checkTryCatchFinally(int check){
        if(check==1){
            return "Not Zero";
        }
        try{
            System.out.println("Inside Try");
            if(check == 2){
                throw new Exception("Exception Message");
            }
            return "Not 2";
        }catch (Exception ex){
            System.out.println("Inside Catch");
        }finally{
            System.out.println("Inside Finally");
        }
        return "End";
    }

    private void comparatorTest(){
        MyComparator myComparator = new MyComparator();
        int result = myComparator.compare("d","c");
        System.out.println(result);
    }

    static private class MyComparator implements Comparator<String> {
        @Override
        public int compare(String item1, String item2) {
            return item1.compareTo(item2);
        }
    }

    private void printCharactersIntegerValues(){
        System.out.println((int)'0'+"-"+(int)'9'); // 48-57
        System.out.println((int)'A'+"-"+(int)'Z'); // 65-90
        System.out.println((int)'a'+"-"+(int)'z'); // 97-122
    }
}
