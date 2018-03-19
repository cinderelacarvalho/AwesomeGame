package org.academiadecodigo.haltistas.AwesomeGame.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class PlayerPosition {

    private Rectangle rectangle;
    private int row;
    private int col;


    PlayerPosition(int row, int col) {
        this.row = row;
        this.col = col;

        int PADDING = 10;
        int CELLSIZE = 10;
        rectangle = new Rectangle(row * CELLSIZE + PADDING, col * CELLSIZE + PADDING,
                CELLSIZE, CELLSIZE);

    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void paintPos(Color color) {
        rectangle.setColor(color);
        rectangle.fill();

    }

    public void deletePos() {
        rectangle.delete();
    }

    public void paintGreenApple() {
        rectangle.setColor(Color.GREEN);
        rectangle.fill();
    }

    public void paintRedApple() {
        rectangle.setColor(Color.RED);
        rectangle.fill();
    }
}
