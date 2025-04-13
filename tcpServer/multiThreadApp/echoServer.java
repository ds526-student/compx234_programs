import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class echoServer {
    public static void main(String[] args) {

        try{
            System.out.println("Waiting for clients...");
            ServerSocket ss = new ServerSocket(52712);

            while (true) {
                Socket soc = ss.accept();
                System.out.println("Client connected: " + soc.getInetAddress().getHostAddress() + ":" + soc.getPort());
                // Handle each client in a separate thread
                new Thread(new ClientHandler(soc)).start();
            }
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String str;
            while ((str = in.readLine()) != null) {
                System.out.println("Received: " + str);
                out.println("Echo: " + str);
            }
        } catch (IOException e) {
            System.out.println("Client disconnected: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
}

