package org.academiadecodigo.haltistas.AwesomeGame.server;

import java.io.*;
import java.net.Socket;

public class ServerHelper implements Runnable {

    private Socket clientSocket;
    private Server server;
    private BufferedReader fromPlayer;
    private int name;


    ServerHelper(int name, Socket clientSocket, Server server) throws IOException {
        this.name = name;
        this.clientSocket = clientSocket;
        this.server = server;
        fromPlayer = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));
    }


    @Override
    public void run() {


        while (!clientSocket.isClosed()) {

            try {

                String msg = fromPlayer.readLine();

                server.receivedMsg(name + "-" + msg);
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
