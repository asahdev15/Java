package socketprogramming;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) throws IOException {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println(scanner.nextLine());

        Socket s = getSocketConnection();

        sendMessage(s.getOutputStream(), "is it working ?");
        readMessage(s.getInputStream());

    }

    private static Socket getSocketConnection() throws IOException{
        System.out.println("Connecting to server...");
        Socket s = new Socket("localhost", 4999);
        System.out.println("Connection established...");
        return s;
    }

    private static void sendMessage(OutputStream os, String message) throws IOException{
        PrintWriter pr = new PrintWriter(os);
        pr.println(message);
        pr.flush();
    }

    private static void readMessage(InputStream is) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        String str = bf.readLine();
        System.out.println(str);
    }

}
