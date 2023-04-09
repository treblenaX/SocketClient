<!-- space -->

# Threading

    Make your client interactive: Users can type at the console and the input goes down the socket
    TIP: you will need to have two Threads:
    one Thread handles command-line I/O (System.in, System.out)
    second Thread handles socket I/O
    Somehow those Threads need to talk to one another

    elbertcheng$ javac ThreadedTCPClient.java ; javac threading/IOThread.java ; javac threading/SocketThread.java ; javac threading/DataPayload.java ; java ThreadedTCPClient.java
    Log level: SEVERE

    Enter a host and port to connect to, separated by a space. Enter 'exit' to quit.
    djxmmx.net 17
    Here's the message you received:
    ================================
    "Is the good life better than the life I live, when I thought that I was gonna go crazy?
    And now my grandmamma ain't the only girl calling me baby..."
            - T-Pain (Good Life)
    ================================
    Enter a host and port to connect to, separated by a space. Enter 'exit' to quit.
    time.nist.gov 13
    Here's the message you received:
    ================================

    60043 23-04-09 06:10:31 50 0 0 800.0 UTC(NIST) * 

    ================================
    Enter a host and port to connect to, separated by a space. Enter 'exit' to quit.



    elbertcheng$ javac ThreadedTCPClient.java ; javac threading/IOThread.java ; javac threading/SocketThread.java ; javac threading/DataPayload.java ; java ThreadedTCPClient.java -f
    Log level: FINE

    Apr 08, 2023 11:08:55 PM threading.IOThread run
    FINE: [IO] IOThread started! Now taking input...
    Enter a host and port to connect to, separated by a space. Enter 'exit' to quit.
    djxmmx.net 17
    Apr 08, 2023 11:08:57 PM threading.SocketThread <init>
    FINE: [SOCKET] Host: djxmmx.net, Port: 17
    Apr 08, 2023 11:08:57 PM threading.SocketThread run
    FINE: [SOCKET] SocketThread started! Connecting to server...
    Apr 08, 2023 11:08:57 PM threading.SocketThread run
    FINE: [SOCKET] Opening socket...
    Apr 08, 2023 11:08:57 PM threading.SocketThread run
    FINE: [SOCKET] Socket connection successful!
    Apr 08, 2023 11:08:57 PM threading.SocketThread run
    INFO: [SOCKET] Message received: "Anyone could see the road that they walk on is paved in gold, and It's always summer, they'll never get cold.
    They'll never get hungry, they'll never get old and gray.
    You can see their shadows wandering off somewhere, they won't make it home but they really don't care.
    They wanted the highway, they're happier there today, today..."
            - Fastball (The Way)
    Apr 08, 2023 11:08:57 PM threading.SocketThread destroy
    FINE: [SOCKET] Closing socket...
    Here's the message you received:
    ================================
    "Anyone could see the road that they walk on is paved in gold, and It's always summer, they'll never get cold.
    They'll never get hungry, they'll never get old and gray.
    You can see their shadows wandering off somewhere, they won't make it home but they really don't care.
    They wanted the highway, they're happier there today, today..."
            - Fastball (The Way)
    ================================
    Enter a host and port to connect to, separated by a space. Enter 'exit' to quit.
    djxmmx.net 17
    Apr 08, 2023 11:09:10 PM threading.SocketThread <init>
    FINE: [SOCKET] Host: djxmmx.net, Port: 17
    Apr 08, 2023 11:09:10 PM threading.SocketThread run
    FINE: [SOCKET] SocketThread started! Connecting to server...
    Apr 08, 2023 11:09:10 PM threading.SocketThread run
    FINE: [SOCKET] Opening socket...
    Apr 08, 2023 11:09:10 PM threading.SocketThread run
    FINE: [SOCKET] Socket connection successful!
    Apr 08, 2023 11:09:10 PM threading.SocketThread run
    INFO: [SOCKET] Message received: "You're way too beautiful girl that's why it'll never work, you'll have me suicidal, suicidal when you say it's over..."
            - Sean Kingston (Beautiful Girls)
    Apr 08, 2023 11:09:10 PM threading.SocketThread destroy
    FINE: [SOCKET] Closing socket...
    Here's the message you received:
    ================================
    "You're way too beautiful girl that's why it'll never work, you'll have me suicidal, suicidal when you say it's over..."
            - Sean Kingston (Beautiful Girls)
    ================================
    Enter a host and port to connect to, separated by a space. Enter 'exit' to quit.
    time.nist.gov 13
    Apr 08, 2023 11:09:26 PM threading.SocketThread <init>
    FINE: [SOCKET] Host: time.nist.gov, Port: 13
    Apr 08, 2023 11:09:26 PM threading.SocketThread run
    FINE: [SOCKET] SocketThread started! Connecting to server...
    Apr 08, 2023 11:09:26 PM threading.SocketThread run
    FINE: [SOCKET] Opening socket...
    Apr 08, 2023 11:09:26 PM threading.SocketThread run
    FINE: [SOCKET] Socket connection successful!
    Apr 08, 2023 11:09:26 PM threading.SocketThread run
    INFO: [SOCKET] Message received: 
    60043 23-04-09 06:09:27 50 0 0 204.0 UTC(NIST) * 

    Apr 08, 2023 11:09:26 PM threading.SocketThread destroy
    FINE: [SOCKET] Closing socket...
    Here's the message you received:
    ================================

    60043 23-04-09 06:09:27 50 0 0 204.0 UTC(NIST) * 

    ================================
    Enter a host and port to connect to, separated by a space. Enter 'exit' to quit.
    exit
    Exiting the application! Goodbye!