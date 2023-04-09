package threading;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IOThread extends Thread {
    final String IDENTITY = "[IO] ";
    final String PROMPT = "Enter a host and port to connect to, separated by a space. Enter 'exit' to quit.";
    DataPayload dataPayload;
    static Scanner scanner;
    Logger LOGGER;

    public IOThread(Logger LOGGER) {
        super();
        this.LOGGER = LOGGER;
        scanner = new Scanner(System.in);
        this.dataPayload = new DataPayload("");
    }

    public void run() {
        LOGGER.fine(IDENTITY + "IOThread started! Now taking input...");
        System.out.println(PROMPT);

        String input = scanner.nextLine();

        try {
            while (!input.equals("exit")) {
                String[] args = input.split(" ");
                SocketThread socketThread = new SocketThread(LOGGER, this.dataPayload, args);
                socketThread.start();
                socketThread.join();

                printData(dataPayload.toString());

                System.out.println(PROMPT);
                input = scanner.nextLine();
            }

        } catch (Exception e) {
            LOGGER.severe(e.toString());
        }

        System.out.println("Exiting the application! Goodbye!");
    }

    public void destroy() {
        scanner.close();
    }

    public void printData(String data) {
        System.out.println("Here's the message you received:");
        System.out.println("================================");
        System.out.println(data);
        System.out.println("================================");
    }
}
