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

        if (words[0].equals("moves1")) {
            if (words[1].equals("r")) {

            }
            if (words[1].equals("l")) {

            }
            if (words[1].equals("u")) {

            }
            if (words[1].equals("d")) {

            }
        }

        if (words[0].equals("moves2")) {
            if (words[1].equals("r")) {

            }
            if (words[1].equals("l")) {

            }
            if (words[1].equals("u")) {

            }
            if (words[1].equals("d")) {

            }

        }

        if (words[0].equals("deletewall")) {
            playerGrid.deleteWall();
        }

        if (words[0].equals("green")) {
            playerGrid.greenApple(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
        }
        if (words[0].equals("red")) {
            playerGrid.redApple(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
        }

        if (words[0].equals("deletepos")) {
            playerGrid.delete(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
        }
        if (words[0].equals("gameover")) {
            if (words[1].equals("p1")) {

            }
            if (words[1].equals("p2")) {

            }
        }
    }
}

