import org.w3c.dom.ls.LSInput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

// java program for a socket client in a simple client-server connection.
public class SocketClient {
    // defining socket and stream variables.
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    // constructor for the client to input ip address and port.
    SocketClient(String address, int port) {

        // establishing a connection
        try {
            socket = new Socket(address, port);

            // read input from stdin
            input = new DataInputStream(System.in);

            // send output to socket
            output = new DataOutputStream(socket.getOutputStream());
        }
        catch (UnknownHostException u) {
            System.out.println(u.getMessage());
        }
        catch (IOException i) {
            System.out.println(i);
        }
        finally {
            System.out.println("Connected! ");
        }

        String line = "";

        while (!line.equals("over!")) {
            try {
                line = input.readLine();
                output.writeUTF(line);
            }
            catch (IOException i) {
                System.out.println(i);
            }
        }

        try {
            input.close();
            output.close();
            socket.close();
        }
        catch(IOException i) {
            System.out.println(i.getMessage());
        }
    }

    public static void main(String[] args) {
        SocketClient client = new SocketClient("127.0.0.1", 8000);
    }

}