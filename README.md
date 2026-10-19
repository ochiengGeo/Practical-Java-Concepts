## Description

A modular, hands-on repository exploring core Java concepts—from network programming (`InetAddress`, TCP/UDP sockets, modern HTTP clients) to concurrency and collections—through runnable, self-contained code examples. Each topic is organized into dedicated directories focused on practical, native API implementations rather than pure theory.

---

## Quick Navigation

<p align="center">
  <a href="./networking/"><img src="https://img.shields.io/badge/Networking-0A66C2?style=for-the-badge&logo=java&logoColor=white" alt="Networking" /></a>
  <a href="./networking/inet-address/"><img src="https://img.shields.io/badge/InetAddress-2563EB?style=for-the-badge" alt="InetAddress" /></a>
  <a href="./networking/tcp-sockets/"><img src="https://img.shields.io/badge/TCP_Sockets-0D9488?style=for-the-badge" alt="TCP Sockets" /></a>
  <a href="./networking/udp-datagrams/"><img src="https://img.shields.io/badge/UDP_Datagrams-7C3AED?style=for-the-badge" alt="UDP Datagrams" /></a>
  <a href="./networking/http-client/"><img src="https://img.shields.io/badge/HTTP_Client-EA580C?style=for-the-badge" alt="HTTP Client" /></a>
  <a href="./Oop/"><img src="https://img.shields.io/badge/OOP-DB2777?style=for-the-badge" alt="Object-Oriented Programming" /></a>
  <a href="./Collections/"><img src="https://img.shields.io/badge/Collections-CA8A04?style=for-the-badge" alt="Collections" /></a>
  <a href="./Concurrency/"><img src="https://img.shields.io/badge/Concurrency-475569?style=for-the-badge" alt="Concurrency" /></a>
</p>

---

---

## Repository Structure

```text
Practical-Java-Concepts/
├── networking/
│   ├── inet-address/
│   │   ├── HostnameResolver.java
│   │   ├── NetworkInterfaceDemo.java
│   │   └── ReachabilityCheck.java
│   ├── tcp-sockets/
│   │   ├── SimpleClient.java
│   │   ├── SimpleServer.java
│   │   └── MultiThreadedServer.java
│   ├── udp-datagrams/
│   │   ├── UDPClient.java
│   │   └── UDPServer.java
│   └── http-client/
│       ├── SyncGetRequest.java
│       └── AsyncPostRequest.java
├── oop/
├── collections/
├── concurrency/
└── README.md
```

## Topics Covered

### Networking

Explore Java's native networking APIs through practical examples.

- **InetAddress:** DNS resolution, IP addresses, network interfaces, and host reachability.
- **TCP Sockets:** Client-server communication, streams, and multithreaded servers.
- **UDP Datagrams:** Connectionless communication using datagram packets.
- **HTTP Client:** Synchronous and asynchronous HTTP requests.

[Explore Networking →](./networking/)

[Explore InetAddress →](./networking/inet-address/)

[Explore TCP Sockets →](./networking/tcp-sockets/)

[Explore UDP Datagrams →](./networking/udp-datagrams/)

[Explore HTTP Client →](./networking/http-client/)

### Object-Oriented Programming (OOP)

Explore object-oriented design, reusable abstractions, and SOLID principles through Java implementations.

[Explore OOP →](./oop/)

### Collections

Explore Java's collection framework, data structures, and Stream API mechanics.

[Explore Collections →](./collections/)

### Concurrency

Explore multithreading, synchronization, locks, and Java's Executor framework.

[Explore Concurrency →](./concurrency/)

---

## Getting Started

1. Clone the repository.
2. Navigate to the directory containing the example you want to explore.
3. Compile the relevant Java source file using `javac`.
4. Run the compiled class using `java`.

Example:

```bash
cd networking/inet-address
javac HostnameResolver.java
java HostnameResolver
