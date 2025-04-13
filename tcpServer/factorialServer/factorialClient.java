import java.io.*;
import java.net.Socket;

public class factorialClient {
    public static void main(String[] args) {
        try {
            System.out.println("Connecting to server...");
            Socket soc = new Socket("localhost", 52714);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a number to calculate its factorial: ");
            int number = Integer.parseInt(userInput.readLine());
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println(number);

            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            System.out.println(in.readLine());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

