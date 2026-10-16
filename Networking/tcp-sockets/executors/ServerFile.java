import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;


public class ServerFile {
    public static void openServer(final int portNumber) {
            try (ServerSocket server = new ServerSocket(portNumber)) {
                System.out.println(ConsoleColors.color("Server is listening on port 5000...", ConsoleColors.YELLOW) );
                try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
                while (true) {
                    Socket client = server.accept();
                    executor.submit(() -> {
                        System.out.println(ConsoleColors.color("[", ConsoleColors.BLUE) + ConsoleColors.color(client.getInetAddress().getHostAddress(), ConsoleColors.BLUE) + ConsoleColors.color(":", ConsoleColors.BLUE) + ConsoleColors.color(String.valueOf(client.getPort()), ConsoleColors.BLUE) + ConsoleColors.color("] Has Connected!", ConsoleColors.BLUE));
                        try (var ClientInput = new BufferedReader(new InputStreamReader(client.getInputStream()));) {
                            var clientIdentity = ClientInput.readLine();
                            System.out.println(ConsoleColors.color("[", ConsoleColors.BLUE) + ConsoleColors.color(client.getInetAddress().getHostAddress(), ConsoleColors.BLUE) + ConsoleColors.color(":", ConsoleColors.BLUE) + ConsoleColors.color(String.valueOf(client.getPort()), ConsoleColors.BLUE) + ConsoleColors.color("] Has changed identity to ", ConsoleColors.BLUE) + ConsoleColors.color(clientIdentity, ConsoleColors.BLUE));
                            clientIdentity = ConsoleColors.color(clientIdentity, ConsoleColors.GREEN);
                            for (String inputLine; (inputLine = ClientInput.readLine()) != null; ) {
                                System.out.println("[" + clientIdentity + "]: " + inputLine);
                            }
                        }
                        catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    });


                    }
                }
            } catch (IOException e) {
                System.out.println("Error while Creating the server");
            }
    }
}
