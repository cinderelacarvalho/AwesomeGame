package tester;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    // This class onlu exists on player side

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 10;
    private Rectangle rect;

    private int cols = 100;
    private int rows = 60;


    public void init() {

        rect = new Rectangle(PADDING,PADDING, cols*CELL_SIZE, rows*CELL_SIZE);
        rect.draw();
    }




}
