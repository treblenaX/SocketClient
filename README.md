<h1>TCP Socket Client</h1>
<p>Please check the individual markdown files or refer to the dropdowns below...</p>
<details>
                <summary>How to Run</summary>
                    <!-- space -->

# Building and running the `Socket Client`/`Logging` exercises:

    javac TCPClient.java ; java TCPClient.java <host> <port> <flag>

>Example command - requesting from djxmmx.net 17

    javac TCPClient.java ; java TCPClient.java djxmmx.net 17

# Building and running the `Threading` exercise:

    javac threading/SocketThread.java ; javac threading/IOThread.java ; javac threading/DataPayload.java ; javac InteractiveTCPClient.java ; java InteractiveTCPClient.java

>Then you can interact with the application in the console!
</details>
<details>
                <summary>Socket Client</summary>
                    <!-- space needed -->

# Write a SocketClient in Java (now with an upgraded application called `InteractiveTCPClient.java`)

    Write a Java app that will

        Connect to a server (command-line parameter) on a port (2nd command-line parameter)
        Take any input passed on the command line (any command-line parameter beyond 2), send it down the socket
        Capture any output from the socket, print it to the console

    Demonstrate that it works by connecting to:

        server djxmmx.net / port 17 (Quote of the Day service)
        server time.nist.gov / port 13 (Date-and-Time service)
        server tcpbin.com / port 4242 or 34.230.40.69 / port 30000 (Echo service)

    In each case, capture the shell session in a video or text file, and put those files into the GitHub repository containing your code.

## `djxmmx.net / port 17`

    elbertcheng$ java TCPClient.java djxmmx.net 17
    "On this day, I see clearly, everything has come to life.
    A bitter place, and a broken dream, and we'll leave it all behind.
    On this day, it's so real to me, everything has come to life.
    Another chance, to chase a dream, another chance to feel, chance to feel alive..."

## `time.nist.gov / port 13`

    elbertcheng$ java TCPClient.java time.nist.gov 13

    60043 23-04-09 02:06:51 50 0 0 132.3 UTC(NIST) * 

## `tcpbin.com / port 4242` - doesn't return anything but Ted said it was fine!

    elbertcheng$ java TCPClient.java tcpbin.com 4242

</details>
<details>
                <summary>Logging</summary>
                    <!-- space -->

# Logging

    Provide diagnostic logging that describes to the console what is happening (1pt)
    The logging is configurable, displaying different "levels" of logging depending on a command-line flag passed in (2 pts)

## 1. Provide diagnostic logging that describes to the console what is happening

I added a LOGGER to my application and printed out the exact actions that the program is going to run to let the user knows exactly what is happening. Then if an error is encountered, it will print an SEVERE level log to let the user know that something went wrong.

    elbertcheng$ javac TCPClient.java ; java TCPClient.java djxmmx.net 17 -f
    Log level: FINE

    Apr 08, 2023 9:21:49 PM TCPClient main
    FINE: Host: djxmmx.net, Port: 17, Flag: -f
    Apr 08, 2023 9:21:49 PM TCPClient main
    INFO: Starting TCPClient...
    Apr 08, 2023 9:21:49 PM TCPClient main
    INFO: Connecting to djxmmx.net:17...
    Apr 08, 2023 9:21:49 PM TCPClient main
    FINE: Opening socket...
    Apr 08, 2023 9:21:49 PM TCPClient main
    FINE: Socket connection successful!
    Apr 08, 2023 9:21:49 PM TCPClient main
    INFO: Message received: "Anyone could see the road that they walk on is paved in gold, and It's always summer, they'll never get cold.
    They'll never get hungry, they'll never get old and gray.
    You can see their shadows wandering off somewhere, they won't make it home but they really don't care.
    They wanted the highway, they're happier there today, today..."
            - Fastball (The Way)
    Apr 08, 2023 9:21:49 PM TCPClient main
    FINE: Closing socket...

## 2. The logging is configurable, displaying different "levels" of logging depending on a command-line flag passed in (2 pts)

There are two main command flags that I implemented: 

    java TCPClient.java <url> <port> -i/I   // INFO/SEVERE logs will be printed
    java TCPClient.java <url> <port> -f/F   // FINE (debug)/INFO/SEVERE logs will be printed
    java TCPClient.java <url> <port>        // SEVERE only logs will be printed

### (default/no flags) `java TCPClient.java djxmmx.net 17` for SEVERE only logs.

    elbertcheng$ javac TCPClient.java ; java TCPClient.java djxmmx.net 17
    Log level: SEVERE

    "I would rather fail in a cause I know some day will triumph, than win in a cause I know some day will fail..."
            - Woodrow Wilson

### `java TCPClient.java djxmmx.net 17 -i` for INFO/SEVERE logs. 

    elbertcheng$ javac TCPClient.java ; java TCPClient.java djxmmx.net 17
    Log level: INFO

    Apr 08, 2023 9:23:26 PM TCPClient main
    INFO: Starting TCPClient...
    Apr 08, 2023 9:23:26 PM TCPClient main
    INFO: Connecting to djxmmx.net:17...
    Apr 08, 2023 9:23:27 PM TCPClient main
    INFO: Message received: "That that don't kill me, can only make me stronger, I need you to hurry up now, cause I can't wait much longer.
    I know I got to be right now, cause I can't get much wronger, man I been waitin' all night now, that's how long I've been on ya..."
            - Kanye West (Stronger)

### `java TCPClient.java djxmmx.net 17 -f` is shown in the example under section 1 above. Can be used for debugging cases!


</details>
<details>
                <summary>Threading</summary>
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
</details>
