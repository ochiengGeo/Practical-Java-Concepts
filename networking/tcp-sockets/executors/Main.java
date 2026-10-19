import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        System.out.print("Is this a Server? (y/n) : ");
        try (var input = new Scanner(System.in)) {
            if (input.nextLine().equalsIgnoreCase("y")) {
                ServerFile.openServer(5000);
            }
            else {
                try {
                    ClientFile.initiateClient("localhost", 5000, input);
                }
                catch (NoSuchElementException e) {
                    System.out.println("\u001B[31m\n<<Server Disconnected.>>\u001B[0m");
                }
            }
        }
        catch (Exception e) {
            System.out.println("\nProgram Terminated: \n"+ e.getMessage());
        }
    }
}
