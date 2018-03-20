package org.academiadecodigo.haltistas.AwesomeGame.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class PlayerPosition {

    private Rectangle rectangle;
    private int row;
    private int col;
    private Picture apple;


    PlayerPosition(int row, int col,int CELL_SIZE, int PADDING) {
        this.row = row;
        this.col = col;


        rectangle = new Rectangle(row * CELL_SIZE + PADDING, col * CELL_SIZE + PADDING,
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

    }

    public void paintGreenApple() {
        apple = new Picture(rectangle.getX(),rectangle.getY(),"resources/maça_verde.png");
        apple.draw();

    }

    public void paintRedApple() {
        apple = new Picture(rectangle.getX(),rectangle.getY(),"resources/maça.png");
        apple.draw();
    }
}
