import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleServer {
    public static void startServer (int port) {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            Socket client = server.accept();
            System.out.println("[" + client.getInetAddress().getHostAddress() + ":" + client.getPort() + "] connected");

            System.out.println("=============================");

            try (
                    var inputStream = client.getInputStream(); //initiate input stream for receiving data from client
                    var reader = new InputStreamReader(inputStream); //convert input byte to ascii
                    var clientInput = new BufferedReader(reader); //assembles the chunks back to the original

                    var outputStream = client.getOutputStream(); //initiates output stream for sending data to client
                    var streamWriter = new OutputStreamWriter(outputStream);
                    var writer = new PrintWriter(streamWriter, true);

                    var input = new Scanner(System.in);

                    ) {
                while (true) {
                    System.out.println(clientInput.readLine());
                    System.out.print("\u001B[36m[Server]: \u001B[0m");
                    var serverMessage = input.nextLine();
                    writer.println("\u001B[36m[Server]: \u001B[0m"  +serverMessage);
                }
            }

        }
        catch (Exception e) {
            System.out.println("\u001B[0m");
        }
    }

    public static void main (String[] args) {
        startServer(8080);
    }
}
