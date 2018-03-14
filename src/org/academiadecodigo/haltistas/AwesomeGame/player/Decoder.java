package org.academiadecodigo.haltistas.AwesomeGame.player;


public class Decoder {

    private PlayerCanvas playerCanvas;

    public Decoder (PlayerCanvas playerCanvas) {

        this.playerCanvas = playerCanvas;
    }


    public void decoding(String msg) {

        String[] words = msg.split("-");
        int x1 = Integer.parseInt(words[1]);
        int y1 = Integer.parseInt(words[1]);
        int x2 = Integer.parseInt(words[1]);
        int y2 = Integer.parseInt(words[1]);


        if (words [0].equals("start")) {
             playerCanvas.start(x1, y1, x2, y2);
        }

        if (words[0].equals("move")) {

        }
    }





}

