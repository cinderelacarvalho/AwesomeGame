package org.academiadecodigo.haltistas.AwesomeGame.player;

import org.academiadecodigo.simplegraphics.graphics.Color;

import java.util.LinkedList;

public class PlayerSnake {

    private PlayerPosition position;
    private LinkedList<PlayerPosition> snakePosition;
    private PlayerGrid grid;
    private Color color;


    public PlayerSnake(PlayerGrid grid, PlayerPosition position1, PlayerPosition position2,
                PlayerPosition position3, Color color) {
        this.grid = grid;
        this.color = color;
        snakePosition = new LinkedList<>();
        increaseSnake(position3, color);
        increaseSnake(position2, color);
        increaseSnake(position1, color);
    }

    public void increaseSnake(PlayerPosition position, Color color) {
        snakePosition.add(0, position);
        position.paintPos(color);
    }


    public void moveDown() {

        position = grid.getPos(snakePosition.get(0).getCol(), (snakePosition.get(0).getRow()) + 1);
        move(position);

    }


    public void moveLeft() {

        position = grid.getPos((snakePosition.get(0).getCol()) - 1, snakePosition.get(0).getRow());
        move(position);

    }

    public void moveRight() {

        position = grid.getPos((snakePosition.get(0).getCol()) + 1, snakePosition.get(0).getRow());
        move(position);

    }


    public void moveUp() {

        position = grid.getPos(snakePosition.get(0).getCol(), (snakePosition.get(0).getRow()) - 1);
        move(position);
    }


    private void move(PlayerPosition newPos) {

        snakePosition.addFirst(newPos);
        newPos.paintPos(color);

    }

    public void removePos() {
        position = snakePosition.get(snakePosition.size() - 1);
        position.deletePos();
        snakePosition.remove(snakePosition.size() - 1);

    }
}

