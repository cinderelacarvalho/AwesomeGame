package org.academiadecodigo.haltistas.AwesomeGame.server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private int portNumber;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ExecutorService executorService;
    private ArrayList<ServerHelper> serverHelpers;
    private Game game;


    Server(int portNumber) {
        this.portNumber = portNumber;

        try {
            serverSocket = new ServerSocket(portNumber);
            executorService = Executors.newCachedThreadPool();
            serverHelpers = new ArrayList<ServerHelper>();
            game = new Game();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void init() {

        start();

    }

    public void start() {

        //  ExecutorService cachedPool = Executors.newCachedThreadPool();  // Or other type of thread


        while (true) {

            try {
                System.out.println("Waiting for connection");
                clientSocket = serverSocket.accept();

                if (clientSocket.isConnected()) {
                    ServerHelper helper = new ServerHelper(clientSocket, this);
                    executorService.submit(helper);
                    serverHelpers.add(helper);

                    System.out.println("connected player " + (serverHelpers.indexOf(helper) + 1));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    //invoked by utilitarian class
    public void broadcast(String msg) {
        synchronized (serverHelpers) {
            for (ServerHelper h : serverHelpers) {

                h.sendMsg(msg);

            }
        }
    }

    public void receivedMsg(String msg) {

        game.receiveMsg(msg);


    }

}

