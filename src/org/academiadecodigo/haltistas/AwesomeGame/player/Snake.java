package org.academiadecodigo.haltistas.AwesomeGame.player;

import java.util.LinkedList;

public class Snake {

    private PlayerPosition playerPosition;
    private LinkedList<PlayerPosition> snakePosition;

    public Snake() {
        snakePosition = new LinkedList<>();
    }

    public void initialSnakeP1(int row, int col) {
        playerPosition = new PlayerPosition(row, col);
        playerPosition.drawPos();
        snakePosition.add(playerPosition);
        playerPosition = new PlayerPosition(row, col-1);
        playerPosition.drawPos();
        snakePosition.add(playerPosition);
        playerPosition = new PlayerPosition(row, col-2);
        playerPosition.drawPos();
        snakePosition.add(playerPosition);


    }

    public void intialSnakeP2(int row, int col){
        playerPosition = new PlayerPosition(row, col);
        playerPosition.drawPos();
        snakePosition.add(playerPosition);
        playerPosition = new PlayerPosition(row, col-1);
        playerPosition.drawPos();
        snakePosition.add(playerPosition);
        playerPosition = new PlayerPosition(row, col-2);
        playerPosition.drawPos();
        snakePosition.add(playerPosition);

    }
}
