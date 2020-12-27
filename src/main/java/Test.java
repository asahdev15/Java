import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {

    public static void main(String[] args){

        System.out.println(isAccessable("https://stackoverflow.com/"));

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
