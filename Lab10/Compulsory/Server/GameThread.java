package Server;

import java.io.*;
import java.net.Socket;

public class GameThread extends Thread {
    private final Socket socket;
    private final DataInputStream dataInputStream;
    private final DataOutputStream dataOutputStream;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public GameThread(Socket socket, DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        this.socket = socket;
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;
    }

    public void run() {
        String command, response;

        while (true) {
            try {

                command = dataInputStream.readUTF();

                if (command.equals("exit")) {
                    System.out.println("Stopping client...");
                    Thread.sleep(100);
                    System.out.println(ANSI_RED + "CLIENT STOPPED" + ANSI_RESET);
                    this.socket.close();
                    break;
                } else if (command.equals("stop")) {
                    System.out.println("Stopping server...");
                    Thread.sleep(100);
                    System.out.println(ANSI_RED + "SERVER STOPPED" + ANSI_RESET);
                    this.socket.close();
                    this.dataInputStream.close();
                    this.dataOutputStream.close();
                    System.exit(0);
                } else {
                    System.out.println(ANSI_GREEN + "Command received: " + command + ANSI_RESET);                    response = "Executing Command";
                    dataOutputStream.writeUTF(response);
                }
            } catch (IOException | InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

}


