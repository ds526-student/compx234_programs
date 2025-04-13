
import java.net.Socket;

public class echoClient {
    public static void main(String[] args) {
        try {
            System.out.println("Client Started");
            Socket soc = new Socket("localhost", 52712);
            System.out.println("Connected to server: " + soc.getInetAddress().getHostAddress() + ":" + soc.getPort());

        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}