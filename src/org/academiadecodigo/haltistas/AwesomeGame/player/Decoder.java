package org.academiadecodigo.haltistas.AwesomeGame.player;


public class Decoder {

    private PlayerGrid playerGrid;

    Decoder(PlayerGrid playerGrid) {

        this.playerGrid = playerGrid;
    }


    public void decoding(String msg) {

        String[] words = msg.split("-");


        if (words[0].equals("start")) {
            playerGrid.start();
        }

        if (words[0].equals("move")) {
            if (words[1].equals("s1")) {
                if (words[2].equals("r")) {
                    playerGrid.moveRightS1();
                }

                if (words[2].equals("l")) {
                    playerGrid.moveLeftS1();
                }

                if (words[2].equals("u")) {

                }

                if (words[2].equals("d")) {

                }

            }
            if (words[1].equals("s2")) {

                if (words[2].equals("r")) {

                }

                if (words[2].equals("l")) {

                }

                if (words[2].equals("u")) {

                }

                if (words[2].equals("d")) {

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

            if (words[0].equals("deletes1")) {
                playerGrid.deleteS1(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
            }

            if (words[0].equals("deletes2")) {
                playerGrid.deleteS1(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
            }

            if (words[0].equals("gameover")) {

                if (words[1].equals("p1")) {

                }

                if (words[1].equals("p2")) {

                }
            }
        }
    }
}

