import java.net.*;
import threading.IOThread;
import java.io.*;
import java.util.logging.*;


public class ThreadedTCPClient {
    final String IDENTITY = "[MAIN] ";
    private static final Logger LOGGER = Logger.getLogger(ThreadedTCPClient.class.getName());

    public static void main(String[] args) {
        String flag = (args.length > 0) ? args[0].toLowerCase() : "";
        Handler consoleHandler = new ConsoleHandler();
        LOGGER.addHandler(consoleHandler);
        LOGGER.setUseParentHandlers(false);

        switch (flag) {
            case "-i":
                LOGGER.setLevel(Level.INFO);
                consoleHandler.setLevel(Level.INFO);
                break;
            case "-f":
                LOGGER.setLevel(Level.FINE);
                consoleHandler.setLevel(Level.FINE);
                break;
            default:
                LOGGER.setLevel(Level.SEVERE);
                consoleHandler.setLevel(Level.SEVERE);
                break;
        }

        System.out.println("Log level: " + LOGGER.getLevel());
        System.out.println();

        IOThread ioThread = new IOThread(LOGGER);
        ioThread.start();
        

        // try {
        //     Handler consoleHandler = new ConsoleHandler();
        // } catch (IOException e) {
        //     LOGGER.severe(e.toString());
        // }
    }
    // public static void main(String[] args) {
    //     String host = args[0];
    //     int port = Integer.parseInt(args[1]);
    //     String flag = (args.length > 2) ? args[2].toLowerCase() : "";

    //     try {
    //         Handler consoleHandler = new ConsoleHandler();
    //         LOGGER.addHandler(consoleHandler);
    //         LOGGER.setUseParentHandlers(false);

    //         switch (flag) {
    //             case "-i":
    //                 LOGGER.setLevel(Level.INFO);
    //                 consoleHandler.setLevel(Level.INFO);
    //                 break;
    //             case "-f":
    //                 LOGGER.setLevel(Level.FINE);
    //                 consoleHandler.setLevel(Level.FINE);
    //                 break;
    //             default:
    //                 LOGGER.setLevel(Level.SEVERE);
    //                 consoleHandler.setLevel(Level.SEVERE);
    //                 break;
    //         }

    //         System.out.println("Log level: " + LOGGER.getLevel());
    //         System.out.println();

    //         LOGGER.fine("Host: " + host + ", Port: " + port + ", Flag: " + flag);
    //         LOGGER.info("Starting TCPClient...");
    //         LOGGER.info("Connecting to " + host + ":" + port + "...");
    //         LOGGER.fine("Opening socket...");

    //         Socket sock = new Socket(host, port);
    //         InputStream in = sock.getInputStream();

    //         LOGGER.fine("Socket connection successful!");
    //         int readChar;
    //         StringBuilder data = new StringBuilder();

    //         while ((readChar = in.read()) != -1) {
    //             data.append((char) readChar);
    //         }

    //         // Only print the data if default flag
    //         if (LOGGER.getLevel() == Level.SEVERE) {
    //             System.out.println(data.toString());
    //         }
            
    //         LOGGER.info("Message received: " + data.toString());
    //         LOGGER.fine("Closing socket...");
    //         sock.close();
    //     } catch (IOException e) {
    //         LOGGER.severe(e.toString());
    //     }
    // }
}