package org.academiadecodigo.haltistas.AwesomeGame.player;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;

public class PlayerGrid {

    private final int CELLSIZE = 10;
    private final int PADDING = 10;
    private final int rows = 100;
    private final int cols = 60;
    private Snake snake;
    private PlayerPosition playerPosition;

    public void init() {
        Rectangle rectangle = new Rectangle(PADDING, PADDING, rows * CELLSIZE, cols * CELLSIZE);
        rectangle.draw();
        snake = new Snake(20,30);
        playerPosition = new PlayerPosition(50,30);

    }


}