package org.academiadecodigo.haltistas.AwesomeGame.player;

import java.io.IOException;

public class PlayerLauncher {

    public static void main(String[] args) {

        PlayerNetwork playerNetwork = null;
        try {
            playerNetwork = new PlayerNetwork("127.0.0.1", 8765);
            playerNetwork.run();

        } catch (IOException e) {
            e.printStackTrace();
        }

       // Thread thread= new Thread(playerNetwork);
       // thread.start();



    }
}
