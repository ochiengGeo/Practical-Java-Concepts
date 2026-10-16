
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Echo server listening on port 5000...");

            try (Socket client = server.accept();
                 BufferedReader reader = new BufferedReader(
                     new InputStreamReader(client.getInputStream())
                 );
                 PrintWriter writer = new PrintWriter(
                     client.getOutputStream(), true
                 )) {

                System.out.println("Client connected.");

                String message = reader.readLine();

                if (message != null) {
                    System.out.println("Received: " + message);
                    writer.println(message);
                    System.out.println("Echo sent.");
                }

            }

            System.out.println("Client disconnected.");

        } catch (IOException e) {
            System.out.println("Networking error: " + e.getMessage());
        }
    }
}
