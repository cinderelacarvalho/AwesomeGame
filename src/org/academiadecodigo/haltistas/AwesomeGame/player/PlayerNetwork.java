package org.academiadecodigo.haltistas.AwesomeGame.player;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class PlayerNetwork implements Runnable {

    private int portNumber;
    private String hostName;
    private Socket playerSocket;
    private PrintWriter toServer;
    private BufferedReader fromServer;
    private Scanner scanner;
    private Decoder decoder;

    PlayerNetwork(String hostName, int portNumber) throws IOException {
        this.hostName = hostName;
        this.portNumber = portNumber;

        scanner = new Scanner(System.in);
        playerSocket = new Socket(hostName, portNumber);
        toServer = new PrintWriter(playerSocket.getOutputStream(), true);
        fromServer = new BufferedReader(new InputStreamReader(playerSocket.getInputStream()));
        PlayerCanvas playerCanvas = new PlayerCanvas();
        decoder = new Decoder(playerCanvas);
        KeyHandler k = new KeyHandler(this);


    }


    public void sendMsg(String msg) {

            toServer.println(msg);
    }


    // this method as 1 thread

    @Override
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

