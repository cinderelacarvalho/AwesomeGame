package org.academiadecodigo.haltistas.AwesomeGame.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class PlayerPosition {

    private final int CELLSIZE = 10;
    private Rectangle rectangle;


    public PlayerPosition(int row, int col) {

        rectangle = new Rectangle(row * CELLSIZE, col * CELLSIZE,
                CELLSIZE, CELLSIZE);

    }

    public void paintPos() {
        rectangle.fill();

    }

    public void deletePos() {
        rectangle.delete();
    }

    public void drawPos(){
        rectangle.draw();
    }

    public void paintGreenApple(){
        rectangle.setColor(Color.GREEN);
        rectangle.fill();
    }

    public void paintRedApple(){
        rectangle.setColor(Color.RED);
        rectangle.fill();
    }

    public void move(int x, int y){
        rectangle.translate(x,y);
    }

}
