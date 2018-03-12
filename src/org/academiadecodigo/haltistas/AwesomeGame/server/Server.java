package org.academiadecodigo.haltistas.AwesomeGame.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    // init() new game / game. start // start()


    private int portNumber = 8080;
    private ServerSocket serverSocket= null;
    private Socket clientSocket = null;

    public void start () {

        ExecutorService cachedPool = Executors.newCachedThreadPool();



    }


}

