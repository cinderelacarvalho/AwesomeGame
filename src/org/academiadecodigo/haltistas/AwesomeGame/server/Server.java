package org.academiadecodigo.haltistas.AwesomeGame.server;

import java.io.IOException;
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


    Server(int portNumber){
        this.portNumber= portNumber;

        try {
            serverSocket= new ServerSocket(portNumber);
            executorService = Executors.newCachedThreadPool();
            serverHelpers = new ArrayList<ServerHelper>();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void init(){

        Game game= new Game();
        //game.start();

        start();

    }

    public void start () {

      //  ExecutorService cachedPool = Executors.newCachedThreadPool();  // Or other type of thread


        while (true){

            try {
                clientSocket = serverSocket.accept();

                if(clientSocket.isConnected()){
                    ServerHelper helper = new ServerHelper(clientSocket,this);
                    executorService.submit(helper);
                    serverHelpers.add(helper);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void sendMsg(String msg){

        game.receiveMsg(msg);

    }


    // Broadcast()



}

