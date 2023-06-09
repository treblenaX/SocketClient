<!-- space -->

# Threading - `InteractiveTCPClient.java`

    Make your client interactive: Users can type at the console and the input goes down the socket
    TIP: you will need to have two Threads:
    one Thread handles command-line I/O (System.in, System.out)
    second Thread handles socket I/O
    Somehow those Threads need to talk to one another

So I made two threads `IOThread.java` and `SocketThread.java`.

`IOThread.java` - Handles the input and output of the user through the use of a Scanner object. Will not terminate until you type in the word: `exit`.

`SocketThread.java` - Handles the socket connection with the server/port that is defined by the user. An examplary command is `djxmmx.net 17`.

The two threads pass data with other by manipulating the `DataPayload.java` object. 

This also supports flags! (-i/-f)

## `java InteractiveTCPClient.java`

    elbertcheng$ javac InteractiveTCPClient.java ; javac threading/IOThread.java ; javac threading/SocketThread.java ; javac threading/DataPayload.java ; java InteractiveTCPClient.java
    Welcome to the Interactive TCP Client!

    Please use the -i flag to set the log level to INFO, and the -f flag to set the log level to FINE.
    If no flag is provided, the log level will be set to SEVERE.

    Enter a host and port to connect to, separated by a space. An example command is 'djxmmx.net 17'. Enter 'exit' to quit.
    djxmmx.net 17


    Here's the message you received:
    ================================
    "See I'ma tell you, like you told me.
    Cash rules everything, around me.
    Singin' dollar dollar bill ya'll, singin' dollar dollar bill ya'll..."
            - Akon (Sweetest Girl, Dollar Bill)
    ================================

    Enter a host and port to connect to, separated by a space. An example command is 'djxmmx.net 17'. Enter 'exit' to quit.
    exit

    Exiting the application! Goodbye!

## `java InteractiveTCPClient.java -f`

    elbertcheng$ javac threading/SocketThread.java ; javac threading/IOThread.java ; javac threading/DataPayload.java ; javac InteractiveTCPClient.java ; java InteractiveTCPClient.java -f
    Welcome to the Interactive TCP Client!

    Please use the -i flag to set the log level to INFO, and the -f flag to set the log level to FINE.
    If no flag is provided, the log level will be set to SEVERE.

    Log level: FINE
    Apr 10, 2023 9:10:23 PM threading.IOThread run
    FINE: [IO] STARTING - IOThread
    Enter a host and port to connect to, separated by a space. An example command is 'djxmmx.net 17'. Enter 'exit' to quit.
    djxmmx.net 17

    Apr 10, 2023 9:10:53 PM threading.SocketThread run
    FINE: [SOCKET] STARTING - SocketThread - djxmmx.net:17...
    Apr 10, 2023 9:10:53 PM threading.SocketThread run
    FINE: [SOCKET] CONN_SUCCESS - SocketThread - djxmmx.net:17...
    Apr 10, 2023 9:10:53 PM threading.SocketThread run
    INFO: [SOCKET] RECEIVED - "Where's there's smoke, there's Snoop Dogg..."
            - Arch Bishop Don "Magic" Jaun (Professional Pimp)
    Apr 10, 2023 9:10:53 PM threading.SocketThread run
    FINE: [SOCKET] EXIT - SocketThread

    Here's the message you received:
    ================================
    "Where's there's smoke, there's Snoop Dogg..."
            - Arch Bishop Don "Magic" Jaun (Professional Pimp)
    ================================
