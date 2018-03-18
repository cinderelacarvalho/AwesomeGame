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
                    playerGrid.moveUpS1();

                }

                if (words[2].equals("d")) {
                    playerGrid.moveDownS1();

                }

            }
            if (words[1].equals("s2")) {


                if (words[2].equals("r")) {
                    playerGrid.moveRightS2();

                }

                if (words[2].equals("l")) {
                    playerGrid.moveLeftS2();

                }

                if (words[2].equals("u")) {
                    playerGrid.moveUpS2();

                }

                if (words[2].equals("d")) {
                    playerGrid.moveDownS2();

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

                    try {
                        playerGrid.gameOverImage();
                        Thread.sleep(3000);
                        playerGrid.player2Wins();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }

                if (words[1].equals("p2")) {
                    try {
                        playerGrid.gameOverImage();
                        Thread.sleep(3000);
                        playerGrid.player1Wins();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}

