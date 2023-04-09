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

    java TCPClient.java [url] [port] -i/I   // INFO/SEVERE logs will be printed
    java TCPClient.java [url] [port] -f/F   // FINE (debug)/INFO/SEVERE logs will be printed
    java TCPClient.java [url] [port]        // SEVERE only logs will be printed

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


