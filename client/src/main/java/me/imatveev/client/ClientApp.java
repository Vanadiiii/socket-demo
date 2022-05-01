package me.imatveev.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApp {
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket("localhost", PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

            final String word = reader.readLine();

            out.write(word + "\n");
            out.flush();

            final String serverResponse = in.readLine();
            System.out.println(serverResponse);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
