import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class factorialServer {
    public static void main(String[] args) {
        try {
            System.out.println("Waiting for clients...");
            ServerSocket ss = new ServerSocket(52714);
            Socket soc = ss.accept();
            System.out.println("Client connected: " + soc.getInetAddress().getHostAddress());
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            int number = Integer.parseInt(in.readLine());
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true); 
            out.println("Factorial of " + number + " is: " + factorial(number));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
