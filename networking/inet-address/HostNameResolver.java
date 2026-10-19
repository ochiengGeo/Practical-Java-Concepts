import java.net.InetAddress;
import java.util.Scanner;
import java.net.UnknownHostException;


public class HostNameResolver {
    public static void main (String[] args) {
        System.out.println();
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter the hostname: ");
        String host = cin.next();
        try {
        InetAddress[] url = InetAddress.getAllByName(host);
        System.out.println();
        System.out.println("The Following are the addresses associated with " + host + ": ");
        for (InetAddress n : url) {
            System.out.println(n.getHostAddress());
        }
    }
    catch (UnknownHostException e) {
        System.out.println("Network info not found!");
    }
    cin.close();
}
}
