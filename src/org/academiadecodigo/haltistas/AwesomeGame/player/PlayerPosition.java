package org.academiadecodigo.haltistas.AwesomeGame.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class PlayerPosition {

    private Rectangle rectangle;
    private int row;
    private int col;
    private Picture apple;


    PlayerPosition(int col, int row, int CELL_SIZE, int PADDING) {
        this.col = col;
        this.row = row;


        rectangle = new Rectangle(col * CELL_SIZE + PADDING, row * CELL_SIZE + PADDING,
                CELL_SIZE, CELL_SIZE);

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

    public void deleteAp() {
        apple.delete();
        apple = null;

    }

    public void paintGreenApple() {

        if (apple != null) {
            return;
        }

        apple = new Picture(rectangle.getX(), rectangle.getY(), "resources/maca-verde.png");
        apple.draw();

    }

    public void paintRedApple() {

        if (apple != null) {
            return;
        }

        apple = new Picture(rectangle.getX(), rectangle.getY(), "resources/maca.png");
        apple.draw();
    }


    public boolean isApple() {
        return apple != null;
    }


    @Override
    public String toString() {
        return apple != null ? "col: " + col + " row: " + row : " ";
    }
}
