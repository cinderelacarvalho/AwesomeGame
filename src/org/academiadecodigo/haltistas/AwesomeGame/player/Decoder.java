package org.academiadecodigo.haltistas.AwesomeGame.player;


public class Decoder {

    private PlayerGrid playerGrid;

    Decoder(PlayerGrid playerGrid) {

        this.playerGrid = playerGrid;
    }


    public void decoding(String msg) {
        int snake = 0;
        int row = 0;
        int col = 0;

        String[] words = msg.split("-");

        System.out.println(msg);

        switch (words[0]) {

            case "start":
                playerGrid.start();
                break;
            case "move":
                snake = Integer.parseInt(words[1]);
                playerGrid.move(snake, words[2]);
                break;
            case "deletewall":
                playerGrid.deleteWall();
                break;
            case "deleteapple":
                row = Integer.parseInt(words[1]);
                col = Integer.parseInt(words[2]);
                System.out.println("\n\n\n\n\nclient received a: " + msg);
                playerGrid.deleteApple(row, col);
                break;
            case "green":
                row = Integer.parseInt(words[1]);
                col = Integer.parseInt(words[2]);
                playerGrid.greenApple(row, col);
                break;
            case "red":
                row = Integer.parseInt(words[1]);
                col = Integer.parseInt(words[2]);
                playerGrid.redApple(row, col);
                break;
            case "delete":
                snake = Integer.parseInt(words[1]);
                playerGrid.deleteSnake(snake);
                break;
            case "gameover":
                playerGrid.gameOver(words[1]);
                break;

        }
    }
}



