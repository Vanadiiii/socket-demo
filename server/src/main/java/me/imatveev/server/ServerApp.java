package me.imatveev.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    private static final int PORT = 9090;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT);
             Socket clientSocket = server.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

            String word = in.readLine();
            System.out.println(word);

            out.write("Hello, it's a server!, you read '" + word + "'!");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
