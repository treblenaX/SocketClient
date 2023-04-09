package threading;

import java.util.Scanner;
import java.util.logging.Logger;

public class IOThread extends Thread {
    final String IDENTITY = "[IO] ";
    final String PROMPT = "Enter a host and port to connect to, separated by a space. An example command is \'djxmmx.net 17\'. Enter 'exit' to quit.";
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
        LOGGER.fine(IDENTITY + "STARTING - IOThread");
        System.out.println(PROMPT);

        String input = scanner.nextLine();
        System.out.println();

        try {
            while (!input.equals("exit")) {
                String[] args = input.split(" ");

                if (args.length != 2) {
                    System.out.println("Invalid input! Please try again.");
                    input = promptUser();
                    continue;
                }

                SocketThread socketThread = new SocketThread(LOGGER, this.dataPayload, args);
                socketThread.start();
                socketThread.join();

                printData(dataPayload.toString());

                input = promptUser();
            }

        } catch (Exception e) {
            LOGGER.severe(e.toString());
        }

        scanner.close();

        LOGGER.fine(IDENTITY + "EXIT - IOThread");
    }

    private String promptUser() {
        System.out.println(PROMPT);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    // make a function that prints the data.



    public void printData(String data) {
        System.out.println();
        System.out.println("Here's the message you received:");
        System.out.println("================================");
        System.out.println(data);
        System.out.println("================================");
        System.out.println();
    }
}
