package socketprogramming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) throws IOException {

        Socket s = startSocketConnection();

        readMessage(s.getInputStream());

        sendMessage(s.getOutputStream(), "YES");
        s.close();



    }

    private static Socket startSocketConnection() throws IOException{
        ServerSocket ss = new ServerSocket(4999);
        System.out.println("Waiting for Client Connection request...");
        Socket s = ss.accept();
        System.out.println("Client Connected...");
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
