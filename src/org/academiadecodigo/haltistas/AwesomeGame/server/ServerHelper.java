package org.academiadecodigo.haltistas.AwesomeGame.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerHelper implements Runnable {

    private Socket clientSocket;
    private Server server;


    public ServerHelper(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;

    }


    @Override
    public void run() {

        while (true) {

            try {
                BufferedReader fromPlayer = new BufferedReader(new InputStreamReader(
                        clientSocket.getInputStream()));

                String msg = fromPlayer.readLine();


                System.out.println(msg);

                server.receivedMsg(msg);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void sendMsg(String msg) {

        try {
            PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true);

            toClient.println(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
