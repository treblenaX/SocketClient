import threading.IOThread;
import java.util.logging.*;


public class InteractiveTCPClient {
    final String IDENTITY = "[MAIN] ";
    private static final Logger LOGGER = Logger.getLogger(InteractiveTCPClient.class.getName());

    public static void main(String[] args) {
        String flag = (args.length > 0) ? args[0].toLowerCase() : "";
        Handler consoleHandler = new ConsoleHandler();
        LOGGER.addHandler(consoleHandler);
        LOGGER.setUseParentHandlers(false);

        System.out.println("Welcome to the Interactive TCP Client!");
        System.out.println();
        System.out.println("Please use the -i flag to set the log level to INFO, and the -f flag to set the log level to FINE.");
        System.out.println("If no flag is provided, the log level will be set to SEVERE.");
        System.out.println();

        switch (flag) {
            case "-i":
                LOGGER.setLevel(Level.INFO);
                consoleHandler.setLevel(Level.INFO);
                printLogLevel();
                break;
            case "-f":
                LOGGER.setLevel(Level.FINE);
                consoleHandler.setLevel(Level.FINE);
                printLogLevel();
                break;
            default:
                LOGGER.setLevel(Level.SEVERE);
                consoleHandler.setLevel(Level.SEVERE);
                break;
        }

        IOThread ioThread = new IOThread(LOGGER);
        ioThread.start();

        try {
            ioThread.join();
        } catch (InterruptedException e) {
            LOGGER.severe(e.toString());
        }

        System.out.println("Exiting the application! Goodbye!");
    }

    private static void printLogLevel() {
        System.out.println("Log level: " + LOGGER.getLevel());
    }
}