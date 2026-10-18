import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
    public static void connect (String host, int port) {
        try (var socket = new Socket(host, port)) {
            System.out.println("Connected to localhost...");


            var outputStream = socket.getOutputStream(); //output stream
            var streamWriter = new OutputStreamWriter(outputStream); //bytes
            var writer = new PrintWriter(streamWriter, true); //enables fns like println

            var inputStream =  socket.getInputStream();
            var reader = new InputStreamReader(inputStream);
            var inputServer = new BufferedReader(reader);

            try (var input = new Scanner(System.in)) {
                while (true) {
                    System.out.print("\u001B[0m");
                    System.out.print("\u001B[36m[Client]: \u001B[0m");
                    var clientInput = input.nextLine();
                    writer.println( "\u001B[36m[Client]: \u001B[0m" + clientInput);
                    inputServer.readLine();
                }
            }
        }
        catch (Exception e) {
            System.out.println("\u001B[0m");
            throw new RuntimeException(e);
        }
    }

    public static void main (String[] args) {
        connect ("localhost", 8080);
    }
}
