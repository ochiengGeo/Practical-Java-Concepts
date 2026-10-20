# Java Networking Laboratory (`networking/`)

## Description

A dedicated hands-on workspace exploring low-level and high-level Java networking primitives (`java.net` package). This directory focuses on practical implementations of network interface inspection, DNS/hostname resolution, TCP client-server architectures, concurrent socket handlers, and socket I/O streams.

This laboratory is actively updated as new networking modules and project implementations are added.

---

## Quick Navigation

<p align="center">
  <a href="./inet-address/"><img src="https://img.shields.io/badge/InetAddress-2563EB?style=for-the-badge&amp;logo=java&amp;logoColor=white" alt="InetAddress" /></a>
  <a href="./tcp-sockets/"><img src="https://img.shields.io/badge/TCP_Sockets-0D9488?style=for-the-badge&amp;logo=java&amp;logoColor=white" alt="TCP Sockets" /></a>
  <a href="../"><img src="https://img.shields.io/badge/Root_Repo-0A66C2?style=for-the-badge" alt="Root Repo" /></a>
</p>

---

## Directory Structure

~~~text
networking/
├── inet-address/
│   ├── HostNameResolver.java
│   └── NicScanner.java
└── tcp-sockets/
    ├── client-server_communication/
    │   ├── SimpleClient.java
    │   ├── SimpleServer.java
    │   └── README.md
    └── executors/
        ├── assets/
        ├── console-chat-application/
        ├── ClientFile.java
        ├── ConsoleColors.java
        ├── Main.java
        ├── ServerFile.java
        └── README.md
~~~

---

## Modules & Completed Projects

### 1. Address & Interface Management (`inet-address/`)
Focuses on local host inspection, network adapter hardware attributes, IP address bindings, and DNS operations[cite: 3].

* **`NicScanner.java`:** A CLI tool that enumerates physical and virtual network adapters (`java.net.NetworkInterface`), extracts MAC addresses, formats MTU/link states, and computes IPv4 CIDR subnet metrics (netmask, network ID, broadcast, host ranges)[cite: 3].
* **`HostNameResolver.java`:** Performs forward and reverse DNS queries, multi-homed IP address array lookups, and host reachability tests via standard `InetAddress` methods[cite: 3].

[Explore InetAddress Module →](./inet-address/)

---

### 2. TCP Socket Programming (`tcp-sockets/`)
Demonstrates reliable stream-oriented transport protocols using Java `Socket` and `ServerSocket` primitives[cite: 4].

* **Basic Client-Server (`client-server_communication/`):** Fundamentals of TCP socket initialization, stream binding (`InputStream`/`OutputStream`), and single-client request-response loops[cite: 4, 5].
* **Concurrent Executors (`executors/`):** Scalable, multi-client server implementations utilizing thread pools via `java.util.concurrent.Executors`, multi-user console chat rooms, and socket file transfer routines[cite: 4, 6].

[Explore TCP Sockets Module →](./tcp-sockets/)

---

## Planned / Upcoming Modules

As progress continues, the following core topics will be integrated into this directory:

* **`udp-datagrams/`:** Connectionless datagram sockets (`DatagramSocket`, `DatagramPacket`) and UDP unicast/broadcast mechanisms.
* **`http-client/`:** Modern Java `HttpClient` API (JDK 11+) for synchronous and asynchronous HTTP/2 request handling.
* **`nio-sockets/`:** Non-blocking I/O using `SocketChannel`, `ServerSocketChannel`, and `Selector` event loops.

---

## Getting Started

1. Navigate into the target module directory:
   ~~~bash
   cd networking/inet-address/
   ~~~
2. Compile the desired Java file:
   ~~~bash
   javac NicScanner.java
   ~~~
3. Execute the program:
   ~~~bash
   java NicScanner
   ~~~
