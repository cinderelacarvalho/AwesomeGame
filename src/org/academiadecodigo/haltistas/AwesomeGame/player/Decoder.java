package org.academiadecodigo.haltistas.AwesomeGame.player;


public class Decoder {

    private PlayerGrid playerGrid;

    public Decoder(PlayerGrid playerGrid) {

        this.playerGrid = playerGrid;
    }


    public void decoding(String msg) {

        String[] words = msg.split("-");
        int x1 = Integer.parseInt(words[1]);
        int y1 = Integer.parseInt(words[2]);
        int x2 = Integer.parseInt(words[3]);
        int y2 = Integer.parseInt(words[4]);


        if (words[0].equals("start")) {
            playerGrid.start();
        }

        if (words[0].equals("moveP1")) {

        }

        if (words[0].equals("moveP2")) {

        }

        if (words[0].equals("deleteWall")) {
            playerGrid.deleteWall();
        }

        if (words[0].equals("greenAp")) {
            // playerGrid.greenApple();
        }
        if (words[0].equals("redA")) {
            //  playerGrid.redApple();
        }

        if (words[0].equals("deletePos")) {
            //playerGrid.delete();
        }
    }
}

