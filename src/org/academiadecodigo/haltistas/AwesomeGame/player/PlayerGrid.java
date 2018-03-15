package org.academiadecodigo.haltistas.AwesomeGame.player;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PlayerGrid {

    private final int CELLSIZE = 10;
    private final int PADDING = 10;
    private final int rows = 100;
    private final int cols = 60;

    public void init() {
        Rectangle rectangle = new Rectangle(PADDING,PADDING,rows*CELLSIZE,cols*CELLSIZE);
        rectangle.draw();
    }


    public void start(int x1, int y1, int x2, int y2) {

        //desenhar grid, wall, desenhar posicao inicial da
    }
}