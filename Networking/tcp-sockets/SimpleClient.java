
import java.io.*;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 5000);
             BufferedReader keyboard = new BufferedReader(
                 new InputStreamReader(System.in)
             );
             BufferedReader reader = new BufferedReader( //instantiates to the object that is responsible for reading the tcp reciever buffer
                 new InputStreamReader(socket.getInputStream())
             );
             PrintWriter writer = new PrintWriter( //instantiates to the object that is responsible for converting unicode to byte code
                 socket.getOutputStream(), true
             )) {

            System.out.print("Enter a message: ");
            String message = keyboard.readLine(); //reads message written by the keyboard

            writer.println(message); //converts the message to bytes

            String response = reader.readLine(); //waits for response, and 'blocks'  so long as there's no response. actually it waits for something on the buffer

            System.out.println("Server replied: " + response);

        } catch (IOException e) {
            System.out.println("Networking error: " + e.getMessage());
        }
    }
}
