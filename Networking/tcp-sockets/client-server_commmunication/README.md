# 💬 Simple TCP Console Messenger

A synchronous, half-duplex bi-directional TCP socket chat client and server implementation in Java. This project demonstrates foundational Java I/O streams (`BufferedReader`, `PrintWriter`, `InputStreamReader`, `OutputStreamWriter`) and socket communication over TCP port 8080 with ANSI-colored console output.

---

## ⚡ Core Features

* 🔌 **Low-Level Socket Communication** — Built using standard `java.net.Socket` and `java.net.ServerSocket`.
* 🔄 **Synchronous Turn-Based Chat** — Implements a structured request-response message flow between client and server.
* 🎨 **ANSI Terminal Styling** — Formatted color-coded output (`\u001B[36m`) for distinguishability in the terminal logs.
* 🛠️ **Resource Management** — Utilizes Java's `try-with-resources` construct for automated stream closing and socket handling.

---

## ⚙️ Tech Stack & Requirements

| Component | Specification |
| :--- | :--- |
| **Language** | Java 11 or higher |
| **Networking** | Standard Java Sockets (`ServerSocket`, `Socket`) |
| **I/O Handling** | `BufferedReader`, `PrintWriter`, `InputStreamReader`, `OutputStreamWriter` |
| **Dependencies** | None (Zero external dependencies) |

---

## 📂 Project Structure

```client-server_communication
├── SimpleServer.java    # TCP Server listening on port 8080
└── SimpleClient.java    # TCP Client connecting to localhost:8080
