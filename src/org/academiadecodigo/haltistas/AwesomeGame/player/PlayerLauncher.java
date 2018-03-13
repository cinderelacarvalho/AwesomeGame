package org.academiadecodigo.haltistas.AwesomeGame.player;

public class PlayerLauncher {

    public static void main(String[] args) {

        Player player = new Player("127.0.0.1", 8765);

        Thread thread= new Thread(player);
        thread.start();

        player.init();

    }
}
