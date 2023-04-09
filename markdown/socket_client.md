<!-- space needed -->

# Write a SocketClient in Java

    Write a Java app that will

        Connect to a server (command-line parameter) on a port (2nd command-line parameter)
        Take any input passed on the command line (any command-line parameter beyond 2), send it down the socket
        Capture any output from the socket, print it to the console

    Demonstrate that it works by connecting to:

        server djxmmx.net / port 17 (Quote of the Day service)
        server time.nist.gov / port 13 (Date-and-Time service)
        server tcpbin.com / port 4242 or 34.230.40.69 / port 30000 (Echo service)

    In each case, capture the shell session in a video or text file, and put those files into the GitHub repository containing your code.

## `server djxmmx.net / port 17`

    elbertcheng$ java TCPClient.java djxmmx.net 17
    "On this day, I see clearly, everything has come to life.
    A bitter place, and a broken dream, and we'll leave it all behind.
    On this day, it's so real to me, everything has come to life.
    Another chance, to chase a dream, another chance to feel, chance to feel alive..."

## `server time.nist.gov / port 13`

    elbertcheng$ java TCPClient.java time.nist.gov 13

    60043 23-04-09 02:06:51 50 0 0 132.3 UTC(NIST) * 

## `server tcpbin.com / port 4242` - doesn't return anything but Ted said it was fine!

    elbertcheng$ java TCPClient.java tcpbin.com 4242

