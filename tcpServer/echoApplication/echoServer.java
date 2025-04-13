import java.net.ServerSocket;
import java.net.Socket;

public class echoServer {
    public static void main(String[] args) {

        try{
            System.out.println("Waiting for clients...");
            ServerSocket ss = new ServerSocket(52712);
            Socket soc = ss.accept();
            System.out.println("Client connected: " + soc.getInetAddress().getHostAddress() + ":" + soc.getPort());

            
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}

