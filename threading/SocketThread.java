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
    }

    public void run() {
        LOGGER.fine(IDENTITY + "STARTING - SocketThread - " + host + ":" + port + "...");

        try {
            synchronized (this) {
                sock = new Socket(host, port);
                in = sock.getInputStream();
    
                LOGGER.fine(IDENTITY + "CONN_SUCCESS - SocketThread - " + host + ":" + port + "...");
    
                int readChar;
                StringBuilder data = new StringBuilder();
    
                while ((readChar = in.read()) != -1) {
                    data.append((char) readChar);
                }
    
                String outputData = data.toString();
                dataPayload.setData(outputData);
    
                LOGGER.info(IDENTITY + "RECEIVED - " + outputData);
                
                notify();   // let the other thread know that the data is there.

                sock.close();
                in.close();

                LOGGER.fine(IDENTITY + "EXIT - SocketThread");
            }
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
        }
    }
}
