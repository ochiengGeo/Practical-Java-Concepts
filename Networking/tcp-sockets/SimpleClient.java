
import java.io.IOException;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 5000)) {
            System.out.println("Connected to the server!");
            System.out.println(
                "Server address: " + socket.getInetAddress()
            );
            System.out.println(
                "Local client port: " + socket.getLocalPort()
            );
            System.out.println(
                "Remote server port: " + socket.getPort()
            );

        } catch (IOException e) {
            System.out.println(
                "Connection failed: " + e.getMessage()
            );
        }
    }
}
