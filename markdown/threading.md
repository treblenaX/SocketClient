<!-- space -->

# Threading

    Make your client interactive: Users can type at the console and the input goes down the socket
    TIP: you will need to have two Threads:
    one Thread handles command-line I/O (System.in, System.out)
    second Thread handles socket I/O
    Somehow those Threads need to talk to one another

> Take a look at `InteractiveTCPClient.java` instead of `TCPClient.java`!

So I made two threads `IOThread.java` and `SocketThread.java`.

`IOThread.java` - Handles the input and output of the user through the use of a Scanner object. Will not terminate until you type in the word: `exit`.

`SocketThread.java` - Handles the socket connection with the server/port that is defined by the user. An examplary command is `djxmmx.net 17`.

The two threads pass data with other by manipulating the `DataPayload.java` object. 

## `java InteractiveTCPClient.java -f`example

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