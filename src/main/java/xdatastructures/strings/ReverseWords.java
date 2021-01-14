package xdatastructures.strings;

public class ReverseWords {

    public static void main(String[] args) {
        System.out.println("_"+reverseWords("a good   example")+"_");
    }

    public static String reverseWords(String s) {
        char[] c = s.toCharArray();
        reverse(c, 0, s.length()-1);
        int i=0;
        for(int j=0; j<=s.length()-1; j++){
            if(c[j]==' '){
                reverse(c, i, j-1);
                i=j+1;
            }
        }
        if(i<=s.length()-1){
            reverse(c, i, s.length()-1);
        }
        return trimMultiSpaces(new String(c));
    }

    public static String trimMultiSpaces(String str){
        String result = new String();
        int i=0;
        int j=0;
        while(i<str.length() || j<str.length()){
            while(i<str.length() && str.charAt(i)==' '){
                i++;
            }
            j=i;
            while(j<str.length() && str.charAt(j)!=' '){
                j++;
            }
            if(i<j){
                if(!result.isEmpty()){
                    result+=" ";
                }
                result+=str.substring(i,j);
            }
            i=j;
        }
        return result;
    }

    public static void reverse(char[] c, int i, int j){
        while(i<j){
            char tmp=c[i];
            c[i]=c[j];
            c[j]=tmp;
            i++;
            j--;
        }
    }
}
