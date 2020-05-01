package Server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class GameServer {


    public static void main(String args[]) throws IOException {

        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;
        ServerSocket serverSocket = new ServerSocket(2407);
        Socket socket = null;
        Thread thread;

        while (true) {
            try {
                socket = serverSocket.accept();
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                thread = new GameThread(socket, dataInputStream, dataOutputStream);
                thread.start();
            } catch (Exception exception) {
                exception.printStackTrace();
                socket.close();
            }
        }

    }
}
