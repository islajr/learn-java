import java.net.*;
import java.io.*;

public class SocketServer extends Thread {
    private ServerSocket serverSocket;

    public SocketServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);

    }

    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();

                System.out.println("connected to " + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());

                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("thank you for connecting to " + server.getLocalAddress() + "\nGoodbye! ");
                server.close();
            }
            catch (SocketTimeoutException s) {
                System.out.println("socket timed out!");
                break;
            }
            catch (IOException i) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);

        try {
            Thread t = new SocketServer(port);
            t.start();
        }
        catch (IOException i) {
            System.out.println(i);
        }
    }
}
