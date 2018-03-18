package org.academiadecodigo.haltistas.AwesomeGame.player;

import java.util.LinkedList;

public class Snake {

    private PlayerPosition position;
    private LinkedList<PlayerPosition> snakePosition;
    private String name;
    private PlayerGrid grid;


    public Snake(String name, PlayerGrid grid, PlayerPosition position1, PlayerPosition position2, PlayerPosition position3) {
        this.name = name;
        this.grid = grid;
        snakePosition = new LinkedList<>();
        increaseSnake(position3);
        increaseSnake(position2);
        increaseSnake(position1);
    }

    public void increaseSnake(PlayerPosition position) {
        snakePosition.add(0,position);
        position.paintPos();
    }

    public void moveRight() {

        position = grid.getPos((snakePosition.get(0).getRow()) + 1, snakePosition.get(0).getCol());
        move(position);

    }


    public void moveUp() {

        position = grid.getPos(snakePosition.get(0).getRow(), (snakePosition.get(0).getCol()) - 1);
        move(position);

    }

    public void moveDown() {

        position = grid.getPos(snakePosition.get(0).getRow(), (snakePosition.get(0).getCol()) + 1);
        move(position);

    }


    public void moveLeft() {

        position = grid.getPos((snakePosition.get(0).getRow()) - 1, (snakePosition.get(0).getCol()));
        move(position);
    }


    public void move(PlayerPosition newPos) {

        snakePosition.addFirst(newPos);
        newPos.paintPos();

    }

    public void removePos(PlayerPosition position){
        position = snakePosition.get(snakePosition.size() - 1);
        position.deletePos();
        snakePosition.remove(snakePosition.size() - 1);

    }

}

