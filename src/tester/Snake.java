package tester;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;
import java.util.List;

public class Snake {


    private List<ServerPosition> positionList;
    private boolean killed;
    private ServerPosition initial1;
    private ServerPosition initial2;
    private ServerPosition initial3;

    public static final int CELLSIZE = 10;
    public static final int PADDING = 10;
    public List<Rectangle> rectangles = new LinkedList<>();


    public Snake(ServerPosition initial1, ServerPosition initial2, ServerPosition initial3) {

        positionList = new LinkedList<>();


        // cenas cliente

        this.initial1 = initial1;
        positionList.add(initial1);
        drawRectangle(initial1);
        this.initial2 = initial2;
        drawRectangle(initial2);
        this.initial3 = initial3;
        drawRectangle(initial3);
    }



    // cenas do lado do cliente
    public void drawRectangle (ServerPosition position) {

        Rectangle rectangle = new Rectangle(position.getColumn() * CELLSIZE + 10, position.getRow() * CELLSIZE + 10, CELLSIZE, CELLSIZE );
        rectangles.add(rectangle);
        rectangle.fill();

    }


}
