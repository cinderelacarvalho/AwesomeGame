package org.academiadecodigo.haltistas.AwesomeGame.server;

import java.io.*;
import java.net.Socket;

public class ServerHelper implements Runnable {

    private Socket clientSocket;
    private Server server;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;


    public ServerHelper(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;

    }


    @Override
    public void run() {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()));

            String msg = in.readLine();


            System.out.println(msg);

            server.sendMsg(msg);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // dataOutputStream=new DataOutputStream(clientSocket.getOutputStream());
}
