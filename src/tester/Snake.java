package tester;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;
import java.util.List;

public class Snake {


    private List<ServerPosition> positionList;
    private String name;
    private boolean killed;
    private ServerPosition initial1;
    private ServerPosition initial2;
    private ServerPosition initial3;
    // inserir propriedade case? nao esta a dar..

    public static final int CELLSIZE = 10;
    public static final int PADDING = 10;
    public List<Rectangle> rectangles = new LinkedList<>();


    public Snake(String name, ServerPosition initial1, ServerPosition initial2, ServerPosition initial3) {

        this.name = name;
        positionList = new LinkedList<>();


        // tem cenas do lado do cliente...

        this.initial1 = initial1;
        positionList.add(initial1);

        drawRectangle(initial1);


        this.initial2 = initial2;
        positionList.add(initial2);

        drawRectangle(initial2);

        this.initial3 = initial3;
        positionList.add(initial3);

        drawRectangle(initial3);


    }


    public String move(Case caseType) {

        ServerPosition position;
        positionList.remove(positionList.size() - 1);
        position = new ServerPosition(positionList.get(0).getColumn(), positionList.get(0).getRow());


        switch (caseType) {

            case UP:


                position.moveUP();
                positionList.add(0, position);

                String up = "move-" + name + "-up";
                return up;

            case DOWN:

                position.moveDown();
                positionList.add(0, position);

                String down = "move-" + name + "-down";
                return down;

            case LEFT:

                position.moveLeft();
                positionList.add(0, position);

                String left = "move-" + name + "-up";
                return left;

            case RIGHT:

                position.moveRight();
                positionList.add(0, position);

                String right = "move-" + name + "-up";
                return right;

            default:
                System.out.println("WTF!");
        }
        return null;


    }


    // cenas do lado do cliente
    public void drawRectangle(ServerPosition position) {

        Rectangle rectangle = new Rectangle(position.getColumn() * CELLSIZE + 10, position.getRow() * CELLSIZE + 10, CELLSIZE, CELLSIZE);
        rectangles.add(rectangle);
        rectangle.fill();

    }



    // cenas do lado do cliente
    public void drawNew(ServerPosition position) {

        Rectangle rectangle = new Rectangle(position.getColumn() * CELLSIZE + 10, position.getRow() * CELLSIZE + 10, CELLSIZE, CELLSIZE);
        rectangles.add(0, rectangle);
        rectangle.fill();

    }

}
