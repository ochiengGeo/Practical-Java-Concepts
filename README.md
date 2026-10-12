## Description

A modular, hands-on repository exploring core Java concepts—from network programming (`InetAddress`, TCP/UDP sockets, modern HTTP clients) to concurrency and collections—through runnable, self-contained code examples. Each topic is organized into dedicated directories focused on practical, native API implementations rather than pure theory.

---

## Repository Structure

```text
Practical-Java-Concepts/
├── networking/
│   ├── inet-address/
│   │   ├── HostnameResolver.java      # DNS lookup & IP address resolution
│   │   ├── NetworkInterfaceDemo.java  # Local network interface & MAC address lookup
│   │   └── ReachabilityCheck.java     # Programmatic host reachability (ping)
│   ├── tcp-sockets/
│   │   ├── SimpleClient.java          # Basic TCP socket connection
│   │   ├── SimpleServer.java          # Single-threaded stream listener
│   │   └── MultiThreadedServer.java  # Thread-pool backed concurrent server
│   ├── udp-datagrams/
│   │   ├── UDPClient.java             # Datagram packet sender
│   │   └── UDPServer.java             # Connectionless packet receiver
│   └── http-client/
│       ├── SyncGetRequest.java        # Synchronous HTTP GET requests
│       └── AsyncPostRequest.java      # Non-blocking HTTP POST calls
├── oop/                               # OOP design patterns & SOLID principles
├── collections/                       # Data structures & Stream API mechanics
├── concurrency/                       # Multithreading, locks & Executor framework
└── README.md
