
import java.io.*;
import java.net.Socket;

public class echoClient {
    public static void main(String[] args) {
        try {
            System.out.println("Client Started");
            Socket soc = new Socket("localhost", 52712);
            System.out.println("Connected to server: " + soc.getInetAddress().getHostAddress() + ":" + soc.getPort());

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));    
            System.out.println("Enter a string");
            String str = userInput.readLine();
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println(str);

            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            System.out.println("Server response: " + in.readLine());
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}