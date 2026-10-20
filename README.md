# Practical Java Concepts

## Description

A modular, hands-on repository exploring core Java concepts—from network programming (`InetAddress`, NIC inspection, TCP/UDP sockets, modern HTTP clients) to concurrency and collections—through runnable, self-contained code examples. Each topic is organized into dedicated directories focused on practical, native API implementations rather than pure theory.

---

## Quick Navigation

<p align="center">
  <a href="./networking/"><img src="https://img.shields.io/badge/Networking-0A66C2?style=for-the-badge&amp;logo=java&amp;logoColor=white" alt="Networking" /></a>
  <a href="./networking/inet-address/"><img src="https://img.shields.io/badge/InetAddress-2563EB?style=for-the-badge" alt="InetAddress" /></a>
  <a href="./networking/tcp-sockets/"><img src="https://img.shields.io/badge/TCP_Sockets-0D9488?style=for-the-badge" alt="TCP Sockets" /></a>
  <a href="./oop/"><img src="https://img.shields.io/badge/OOP-DB2777?style=for-the-badge" alt="Object-Oriented Programming" /></a>
  <a href="./collections/"><img src="https://img.shields.io/badge/Collections-CA8A04?style=for-the-badge" alt="Collections" /></a>
  <a href="./concurrency/"><img src="https://img.shields.io/badge/Concurrency-475569?style=for-the-badge" alt="Concurrency" /></a>
</p>

---

---

## Repository Structure

~~~text
Practical-Java-Concepts/
├── networking/
│   ├── inet-address/
│   │   ├── HostNameResolver.java
│   │   └── NicScanner.java
│   └── tcp-sockets/
│       ├── client-server_communication/
│       │   ├── SimpleClient.java
│       │   ├── SimpleServer.java
│       │   └── README.md
│       └── executors/
│           ├── assets/
│           ├── console-chat-application/
│           ├── ClientFile.java
│           ├── ConsoleColors.java
│           ├── Main.java
│           ├── ServerFile.java
│           └── README.md
├── oop/
├── collections/
├── concurrency/
└── README.md
~~~

---

## Topics Covered

### Networking

Explore Java's native networking APIs through practical, structured subdirectories.

- **InetAddress & Network Interfaces (`inet-address/`):** Hostname resolution, IP address management, network adapter enumeration, MAC formatting, and subnet calculations via `NicScanner.java` and `HostNameResolver.java`.
- **TCP Sockets (`tcp-sockets/`):**
  - **Basic Client-Server (`client-server_communication/`):** Single-client communication using Java `Socket` and `ServerSocket` I/O streams.
  - **Concurrent Executors (`executors/`):** Multi-client architectures, thread pools via the Executor framework, file transfers, and styled console chat systems.

[Explore Networking →](./networking/)

[Explore InetAddress →](./networking/inet-address/)

[Explore TCP Sockets →](./networking/tcp-sockets/)

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

~~~bash
cd networking/inet-address
javac HostNameResolver.java
java HostNameResolver
~~~
