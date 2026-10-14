
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Server is listening on port 5000...");

            try (Socket client = server.accept()) {
                System.out.println("Client connected!");
                System.out.println(
                    "Client address: " + client.getInetAddress()
                );
                System.out.println(
                    "Client port: " + client.getPort()
                );
            }

            System.out.println("Client connection closed.");

        } catch (IOException e) {
            System.out.println("Networking error: " + e.getMessage());
        }
    }
}
