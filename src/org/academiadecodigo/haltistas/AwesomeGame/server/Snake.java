package org.academiadecodigo.haltistas.AwesomeGame.server;

import javax.swing.text.Position;
import java.util.LinkedList;
import java.util.List;

public class Snake {

    private List<ServerPosition> positionList;
    private String name;
    private boolean killed;
    private String direction;


    public Snake(String name, ServerPosition initial1, ServerPosition initial2, ServerPosition initial3) {

        this.name = name;
        positionList = new LinkedList<>();

        positionList.add(initial1);
        positionList.add(initial2);
        positionList.add(initial3);

        direction = "up";

    }


    public void move (String msg) {

        Case caseType = setDirection(msg);

        ServerPosition position = new ServerPosition(positionList.get(0).getColumn(), positionList.get(0).getRow());




    }



    public Case setDirection(String msg) {

        if (msg.equals("up") && (direction.equals("right") || direction.equals("left"))) {

            direction = "up";
            return Case.UP;

        }

        if (msg.equals("down") && (direction.equals("right") || direction.equals("left"))) {

            direction = "down";
            return Case.DOWN;

        }

        if (msg.equals("left") && (direction.equals("up")) || direction.equals("down")) {

            direction = "left";
            return Case.LEFT;

        }

        if (msg.equals("right") && (direction.equals("up")) || direction.equals("down")) {

            direction = "right";
            return Case.RIGHT;
        }

        return Case.NULL;

    }

}
