package org.academiadecodigo.haltistas.AwesomeGame.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class PlayerPosition {

    private final int CELLSIZE = 10;
    private final int PADDING = 10;
    private Rectangle rectangle;
    private int row;
    private int col;


    public PlayerPosition(int row, int col) {
        this.row = row;
        this.col = col;

        rectangle = new Rectangle(row * CELLSIZE+PADDING, col * CELLSIZE+PADDING,
                CELLSIZE, CELLSIZE);

    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void paintPos() {
        rectangle.fill();

    }

    public void deletePos() {
        rectangle.delete();
    }

    public void drawPos() {
        rectangle.draw();
    }

    public void paintGreenApple() {
        rectangle.setColor(Color.GREEN);
        rectangle.fill();
    }

    public void paintRedApple() {
        rectangle.setColor(Color.RED);
        rectangle.fill();
    }

    public void move(int x, int y) {
        rectangle.translate(x, y);
    }

}
