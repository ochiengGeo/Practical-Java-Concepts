import java.io.PrintWriter;
import java.net.Socket;
import java.io.IOException;
import java.util.Scanner;

public class ClientFile {
   public static void initiateClient (String Host, int portNumber, Scanner scanner) {
                try (Socket socket = new Socket(Host, portNumber)) {
                    System.out.println(ConsoleColors.color("Connected to ", ConsoleColors.BLUE) + ConsoleColors.color(Host, ConsoleColors.BLUE) + ConsoleColors.color("[✓].", ConsoleColors.BLUE));
                    var writer = new PrintWriter(socket.getOutputStream(), true);
                    System.out.print("Enter your username: ");
                    String username = scanner.nextLine();
                    writer.println(username);
                    username = ConsoleColors.color(username, ConsoleColors.GREEN);
                    System.out.print("["+ username + "]: ");
                    System.out.print("\u001B[36m");
                    for (String userInput; !(userInput = scanner.nextLine()).isEmpty(); ) {
                        System.out.print("\u001B[0m" + "["+ username + "]: ");
                        System.out.print("\u001B[36m");
                        writer.println(ConsoleColors.color(userInput, ConsoleColors.CYAN));
                    }
                }
                catch (IOException e) {
                    System.out.println("Cannot connect to the Server, check your connection.");
                }
    }
}
