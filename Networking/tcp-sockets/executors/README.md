Console Chat Application

A lightweight, concurrent multi-client TCP chat application written in Java. The application features a simple command-line interface, ANSI color-coded console output, and leverages Java Virtual Threads (Executors.newVirtualThreadPerTaskExecutor()) to handle multiple incoming client connections concurrently.

Features

Virtual Threads Execution: Uses Project Loom's lightweight virtual threads to handle concurrent client connections efficiently.

Custom Identity/Username: Clients specify a username upon connection, which prefixes all their messages on the server log.

Colored Terminal Output: Includes ANSI escape codes for formatted console status messages and distinct chat coloring.

Single Entry Point: Unified executable flow via Main.java allowing execution as either server or client.

Requirements

Java Development Kit (JDK): JDK 21 or higher (required for virtual threads support).

Project Structure

.
├── Main.java          # Entry point (handles mode selection)
├── ServerFile.java    # Server logic & client handling using Virtual Threads
├── ClientFile.java    # Client logic & socket output stream handler
└── ConsoleColors.java # ANSI color constants and formatting helper


Getting Started

1. Compilation

Compile all Java source files from the project directory:

javac *.java


2. Running the Server

Start the application and enter y when prompted to launch the server mode.

java Main


Is this a Server? (y/n) : y
Server is listening on port 5000...


The server listens on TCP port 5000 by default.

3. Running a Client

Open another terminal window (or run on another device on the same network) and start the application, entering n when prompted:

java Main


Is this a Server? (y/n) : n
Connected to localhost[✓].
Enter your username: Alice
[Alice]: Hello, server!


To disconnect the client, submit an empty line (press Enter without typing a message).
