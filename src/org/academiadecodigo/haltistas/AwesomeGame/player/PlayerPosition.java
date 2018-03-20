package org.academiadecodigo.haltistas.AwesomeGame.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class PlayerPosition {

    private Rectangle rectangle;
    private int row;
    private int col;
    private Picture apple;


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

    public void deleteAp() {
        apple.delete();

    }

    public void paintGreenApple() {
        apple = new Picture(rectangle.getX(),rectangle.getY(),"resources/maça_verde.png");
        apple.draw();

        /*
        rectangle.setColor(Color.GREEN);
        rectangle.fill(); */
    }

    public void paintRedApple() {
        apple = new Picture(rectangle.getX(),rectangle.getY(),"resources/maça.png");
        apple.draw();

        /*
        rectangle.setColor(Color.RED);
        rectangle.fill(); */
    }
}
