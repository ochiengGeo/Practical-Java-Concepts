import java.net.*;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class NicScanner {

    public static void main (String[] args) {
        boolean showAll = false;
        String targetInterface = null;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--all": case "-a": showAll = true; break;
                case "--interface": case "-i":
                    if (i + 1 < args.length) {
                        targetInterface = args[++i];
                    }
                    else {
                        System.err.println("Error: -i / --interface requires an interface name.");
                        return;
                    }
                    break;
                case "--help": case "-h": printHelp(); return;
                default : System.err.println("Unknown argument: " + args[i]); printHelp(); return;
            }
        }

        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            if (interfaces == null) {
                System.out.println("No interfaces found.");
                return;
            }

            System.out.println("================================================================================");
            System.out.println("                        LOCAL NETWORK INTERFACE SCANNER                         ");
            System.out.println("================================================================================");

            int count = 0;
            for (var n : Collections.list(interfaces)) {
                if (targetInterface != null && !n.getName().equalsIgnoreCase(targetInterface)) {
                    continue;
                }
                if (!showAll && (!n.isUp() || n.isLoopback())) {
                    continue;
                }
                printInterfaceDetails(n);
                count++;
            }
            System.out.println("================================================================================");
            System.out.printf("Scan complete. Displayed %d interface(s).%n", count);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static void printInterfaceDetails(NetworkInterface netIf) throws SocketException {
        String type = netIf.isLoopback() ? "LOOPBACK" : (netIf.isVirtual() ? "VIRTUAL" : "PHYSICAL");
        String status = netIf.isUp() ? "UP" : "DOWN";

        System.out.printf("%n[+] Interface: %s (%s)%n", netIf.getName(), netIf.getDisplayName());
        System.out.printf("    ├── Status:           %s%n", status);
        System.out.printf("    ├── Type:             %s%n", type);
        System.out.printf("    ├── MAC Address:      %s%n", formatMacAddress(netIf.getHardwareAddress()));
        System.out.printf("    ├── MTU:              %d bytes%n", netIf.getMTU());

        List<InterfaceAddress> bindingList = netIf.getInterfaceAddresses();
        if (bindingList.isEmpty()) {
            System.out.println("    └── Bound Addresses:  None");
            return;
        }

        System.out.println("    └── Bound Addresses:");
        for (int i = 0; i < bindingList.size(); i++) {
            InterfaceAddress ifAddr = bindingList.get(i);
            InetAddress addr = ifAddr.getAddress();
            boolean isLast = (i == bindingList.size() - 1);
            String prefix = isLast ? "        └── " : "        ├── ";
            String subPrefix = isLast ? "            " : "        │   ";

            if (addr instanceof Inet4Address) {
                printIPv4Details((Inet4Address) addr, ifAddr.getNetworkPrefixLength(), prefix, subPrefix);
            } else {
                System.out.printf("%sIPv6:         %s (Link-Local/Global)%n", prefix, addr.getHostAddress());
            }
        }
    }

    private static void printIPv4Details(Inet4Address ip, short prefixLength, String prefix, String subPrefix) {
        System.out.printf("%sIPv4:         %s%n", prefix, ip.getHostAddress());

        if (prefixLength > 0 && prefixLength <= 32) {
            int maskInt = 0xFFFFFFFF << (32 - prefixLength);
            int ipInt = ipToBits(ip);
            int netInt = ipInt & maskInt;
            int bcastInt = netInt | ~maskInt;

            String netmask = bitsToIp(maskInt);
            String network = bitsToIp(netInt);
            String broadcast = bitsToIp(bcastInt);

            long totalHosts = (prefixLength >= 31) ? 0 : ((1L << (32 - prefixLength)) - 2);
            String usableFirst = bitsToIp(netInt + 1);
            String usableLast = bitsToIp(bcastInt - 1);

            System.out.printf("%s├── Netmask:  %s (/%d)%n", subPrefix, netmask, prefixLength);
            System.out.printf("%s├── Network:  %s%n", subPrefix, network);
            System.out.printf("%s├── Broadcast:%s%n", subPrefix, broadcast);
            if (totalHosts > 0) {
                System.out.printf("%s└── Usable:   %s - %s (%d hosts)%n", subPrefix, usableFirst, usableLast, totalHosts);
            } else {
                System.out.printf("%s└── Usable:   Point-to-Point / Single Host%n", subPrefix);
            }
        }
    }

    private static String formatMacAddress(byte[] mac) {
        if (mac == null) return "N/A";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : ""));
        }
        return sb.toString();
    }

    private static int ipToBits(Inet4Address ip) {
        byte[] bytes = ip.getAddress();
        return ((bytes[0] & 0xFF) << 24) |
                ((bytes[1] & 0xFF) << 16) |
                ((bytes[2] & 0xFF) << 8)  |
                (bytes[3] & 0xFF);
    }

    private static String bitsToIp(int bits) {
        return String.format("%d.%d.%d.%d",
                (bits >> 24) & 0xFF,
                (bits >> 16) & 0xFF,
                (bits >> 8) & 0xFF,
                bits & 0xFF);
    }

    private static void printHelp() {
        System.out.println("Usage: java NicScanner [options]");
        System.out.println("Options:");
        System.out.println("  -a, --all               Show all interfaces (including down and loopback)");
        System.out.println("  -i, --interface <name>  Inspect a specific interface (e.g., eth0, wlan0)");
        System.out.println("  -h, --help              Display usage information");
    }
}

