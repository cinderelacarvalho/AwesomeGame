package org.academiadecodigo.haltistas.AwesomeGame.player;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class PlayerPosition {

    private int row;
    private int col;
    private final int CELLSIZE = 10;

    public PlayerPosition(int row, int col) {
        this.col = col;
        this.row = row;
        drawPos();
    }

    public void drawPos() {
        Rectangle rectangle = new Rectangle(row*CELLSIZE, col*CELLSIZE,
                CELLSIZE,CELLSIZE);
        rectangle.draw();
    }




}
