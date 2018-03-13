package org.academiadecodigo.haltistas.AwesomeGame.player;

import java.io.IOException;

public class PlayerLauncher {

    public static void main(String[] args) {

        Player player = null;
        try {
            player = new Player("127.0.0.1", 8765);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread thread= new Thread(player);
        thread.start();

        player.sendMsg();

    }
}
