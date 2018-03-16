package org.academiadecodigo.haltistas.AwesomeGame.player;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class PlayerPosition {

    private int row;
    private int col;
    private final int CELLSIZE = 10;
    private Rectangle rectangle;


    public PlayerPosition(int row, int col) {

        rectangle = new Rectangle(row * CELLSIZE, col * CELLSIZE,
                CELLSIZE, CELLSIZE);

    }

    public void drawPos() {

        rectangle.fill();

    }

    public void delete() {
        rectangle.delete();
    }



}
