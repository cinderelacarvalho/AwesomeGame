package org.academiadecodigo.haltistas.AwesomeGame.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ExecutorService executorService;
    private ArrayList<ServerHelper> serverHelpers;
    private ServerGrid serverGrid;


    public Server(int portNumber) {

        try {
            serverSocket = new ServerSocket(portNumber);
            executorService = Executors.newCachedThreadPool();
            serverHelpers = new ArrayList<>();
            serverGrid = new ServerGrid(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void init() {

        serverGrid.init();
        start();

    }

    public void start() {

        //  ExecutorService cachedPool = Executors.newCachedThreadPool();  // Or other type of thread


        while (true) {

            try {
                System.out.println("Waiting for connection");
                clientSocket = serverSocket.accept();

                ServerHelper helper = new ServerHelper(clientSocket, this);
                executorService.submit(helper);
                serverHelpers.add(helper);

                System.out.println("connected player " + (serverHelpers.indexOf(helper) + 1));

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

        serverGrid.receiveMsg(msg);



    }

}

