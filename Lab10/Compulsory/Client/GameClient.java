import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class GameClient {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String args[]) {
        Socket socket = new Socket();
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;


        try {
            Scanner scanner = new Scanner(System.in);

            InetAddress ipAddress = InetAddress.getByName("localhost");

            Socket s = new Socket(ipAddress, 2407);

            dataInputStream = new DataInputStream(s.getInputStream());
            dataOutputStream = new DataOutputStream(s.getOutputStream());

            System.out.println("Reserved commands:\n -> " + ANSI_GREEN + "exit\n" + ANSI_RESET + " -> " + ANSI_GREEN + "stop\n" + ANSI_RESET);

            while (true) {
                String command = scanner.nextLine();
                dataOutputStream.writeUTF(command);

                if (command.equals("exit")) {
                    s.close();
                    break;
                }

                if (command.equals("stop")) {
                    s.close();
                    System.out.println("Server stopped.\n");
                    break;
                }
            }
            scanner.close();
            dataInputStream.close();
            dataOutputStream.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}


