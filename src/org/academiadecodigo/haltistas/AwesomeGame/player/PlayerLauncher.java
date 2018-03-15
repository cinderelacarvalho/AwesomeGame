package org.academiadecodigo.haltistas.AwesomeGame.player;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlayerLauncher {

    public static void main(String[] args) {

        PlayerNetwork playerNetwork = null;
        try {
            playerNetwork = new PlayerNetwork("127.0.0.1", 8765);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(playerNetwork);

       // Thread thread= new Thread(playerNetwork);
       // thread.start();



    }
}
