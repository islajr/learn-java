import javax.xml.crypto.Data;
import java.net.*;
import java.io.*;

public class SocketClient {
    public static void main(String[] args) {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);

        try {
            System.out.println("connecting to " + serverName + "on port " + port);
            Socket socket = new Socket(serverName, port);

            System.out.println("connected to " + socket.getRemoteSocketAddress());
            OutputStream out = socket.getOutputStream();
            DataOutputStream output = new DataOutputStream(out);

            output.writeUTF("hello from " + socket.getLocalSocketAddress());
            InputStream in = socket.getInputStream();
            DataInputStream input = new DataInputStream(in);

            System.out.println("server says " + input.readUTF());
            socket.close();
        }
        catch(IOException i) {
            System.out.println(i);
        }
    }
}