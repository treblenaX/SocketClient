package threading;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class SocketThread extends Thread {
    final String IDENTITY = "[SOCKET] ";
    DataPayload dataPayload;
    Socket sock;
    InputStream in;
    Logger LOGGER;
    String host;
    int port;


    public SocketThread(Logger LOGGER, DataPayload dataPayload, String[] args) {
        super();
        this.LOGGER = LOGGER;
        this.dataPayload = dataPayload;

        host = args[0];
        port = Integer.parseInt(args[1]);

        LOGGER.fine(IDENTITY + "Host: " + host + ", Port: " + port);
    }

    public void run() {
        LOGGER.fine(IDENTITY + "SocketThread started! Connecting to server...");

        try {
            synchronized (this) {
                LOGGER.fine(IDENTITY + "Opening socket...");
    
                sock = new Socket(host, port);
                in = sock.getInputStream();
    
                LOGGER.fine(IDENTITY + "Socket connection successful!");
    
                int readChar;
                StringBuilder data = new StringBuilder();
    
                while ((readChar = in.read()) != -1) {
                    data.append((char) readChar);
                }
    
                String outputData = data.toString();
                dataPayload.setData(outputData);
    
                LOGGER.info(IDENTITY + "Message received: " + outputData);
                
                notify();
                destroy();
            }
        } catch (Exception e) {
            LOGGER.severe(e.toString());
        }
    }


    public void destroy() {
        try {
            sock.close();
            in.close();
            LOGGER.fine(IDENTITY + "Closing socket...");
        } catch (IOException e) {
            LOGGER.severe(e.toString());
        }
    }
}
