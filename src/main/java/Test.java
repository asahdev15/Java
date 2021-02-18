import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args){

        List<Integer> arr = new LinkedList<>();
        arr.add(7);
        arr.add(8);

        int count = 0;
        int leftSum = 0;
        int rightSum = arr.stream().mapToInt(i->i).sum();
        for(int i=0; i<arr.size()-1; i++){
            leftSum = leftSum + arr.get(i);
            rightSum = rightSum - arr.get(i);
            if(leftSum > rightSum) count++;
        }
        System.out.println(count);

    }
    public static boolean isAccessable(String url) {
        url = url.replaceFirst("https", "http");
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            if (responseCode != 200) {
                return false;
            }
        } catch (IOException exception) {
            return false;
        }
        return true;
    }


}
