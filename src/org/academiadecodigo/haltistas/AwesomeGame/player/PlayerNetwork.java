package org.academiadecodigo.haltistas.AwesomeGame.player;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class PlayerNetwork {

    private Socket playerSocket;
    private PrintWriter toServer;
    private BufferedReader fromServer;
    private Decoder decoder;

    PlayerNetwork(String hostName, int portNumber) throws IOException {
        playerSocket = new Socket(hostName, portNumber);

    }

    public void init() throws IOException {
        toServer = new PrintWriter(playerSocket.getOutputStream(), true);
        fromServer = new BufferedReader(new InputStreamReader(playerSocket.getInputStream()));
        PlayerGrid playerGrid = new PlayerGrid();
        playerGrid.init();
        decoder = new Decoder(playerGrid);
        KeyHandler k = new KeyHandler(this);


    }


    public void sendMsg(String msg) {

            toServer.println(msg);
    }


    // this method as 1 thread
    public void run() {

        while (playerSocket.isConnected()) {

            try {
                String msgFromServer = fromServer.readLine();

                decoder.decoding(msgFromServer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

