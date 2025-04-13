import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class echoServer {
    public static void main(String[] args) {

        try{
            System.out.println("Waiting for clients...");
            ServerSocket ss = new ServerSocket(52712);
            Socket soc = ss.accept();
            System.out.println("Client connected: " + soc.getInetAddress().getHostAddress() + ":" + soc.getPort());

            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String str = in.readLine();
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println("Echo: " + str);
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}

