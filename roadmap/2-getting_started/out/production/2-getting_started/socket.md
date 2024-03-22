# Socket Programming in Java
Socket programming allows users on a network to share data with one another with the use of 'sockets'.

A **socket** is an endpoint of a two-way communication link between two programs running on a network.
In other words, a socket represents one point on a network where data can be sent and received.

A socket is bound to a **port number**, so that the TCP layer of the network can correctly identify the application that the data is to be sent.

To write programs across networks, including socket programming, knowledge of the java.net package is crucial.

Sockets primarily work with the TCP (Transmission Control Protocol) which allows for reliable communication between two applications.

Sockets also depend on UDP (User Datagram Protocol) which is a connection-less protocol that allows for packets of data to be transmitted between applications.

## Steps for establishing socket connections
- create a ServerSocket object, denoting which port it is to listen on.
- create a Socket object on the client, specifying the server name and port.

If a connection is established, the client now has a socket capable of communicating with the server.
