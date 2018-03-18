package org.academiadecodigo.haltistas.AwesomeGame.server;

import sun.tools.tree.CaseStatement;

import javax.swing.text.Position;
import java.util.LinkedList;
import java.util.List;

public class Snake {

    private List<ServerPosition> positionList;
    private String name;
    private boolean over;
    private Case caseType;
    private boolean isEatingGreen;
    private boolean isEatingRed;


    public Snake(String name, ServerPosition initial1, ServerPosition initial2, ServerPosition initial3) {

        this.name = name;
        caseType = Case.UP;
        positionList = new LinkedList<>();

        positionList.add(initial1);
        positionList.add(initial2);
        positionList.add(initial3);

    }

    public void setDirection(String msg) {

        if (msg.equals("up") && (caseType.equals(Case.RIGHT) || caseType.equals(Case.LEFT))) {
            caseType = Case.UP;
        }

        if (msg.equals("down") && (caseType.equals(Case.RIGHT) || caseType.equals(Case.LEFT))) {
            caseType = Case.DOWN;
        }

        if (msg.equals("left") && (caseType.equals(Case.UP)) || caseType.equals(Case.DOWN)) {
            caseType = Case.LEFT;
        }

        if (msg.equals("right") && (caseType.equals(Case.UP)) || caseType.equals(Case.DOWN)) {
            caseType = Case.RIGHT;
        }
        caseType = caseType;

    }

    public String move() {

        ServerPosition position = new ServerPosition(positionList.get(0).getColumn(), positionList.get(0).getRow());
        String msg = new String();

        switch (caseType) {

            case UP:

                position.moveUP();
                positionList.add(0, position);

                if (position.getRow() == ServerPosition.MIN_ROW) {
                    over = true; // ver devolucao de snakes
                }

                msg = "move-" + name + "-u";
                break;

            case DOWN:

                position.moveDown();
                positionList.add(0, position);

                if (position.getRow() == ServerPosition.MAX_ROW) {
                    over = true; // ....
                }

                msg = "move-" + name + "d";
                break;

            case LEFT:

                position.moveLeft();
                positionList.add(0, position);

                if (position.getColumn() == ServerPosition.MIN_COLUNM) {
                    over = true; // ....
                }

                msg = "move-" + name + "-l";
                break;

            case RIGHT:

                position.moveRight();
                positionList.add(0, position);

                if (position.getColumn() == ServerPosition.MAX_COLUNM) {
                    over = true; //.......
                }

                msg = "move-" + name + "-r";
                break;

            default:

                System.out.println("WTF!");
                break;

        }
        return msg;
    }

    public String deleteLast() {

        int col = (positionList.get(positionList.size() - 1).getColumn());
        int row = (positionList.get(positionList.size() - 1).getRow());
        positionList.remove(positionList.size() - 1);

        String delete = "delete" + name + "-" + row + "-" + col;
        return delete;
    }

    public boolean isColliding(Snake snake) {// falta distinguir qual delas com a head

        for (ServerPosition position1 : positionList) {
            for (ServerPosition position2 : snake.positionList) {
                if (position1.equals(position2)) {
                    return over = true;
                }
            }

        }
        return over = false;
    }

    public boolean isEatingGreen(List green) { //continuar quando tiver maçãs

        ServerPosition head = new ServerPosition(positionList.get(0).getColumn(), positionList.get(0).getRow());

        for (ServerPosition position : positionList) {
            if (apple.compare(position)) {
                return isEatingGreen = true;
            }
        }
        return isEatingGreen = false; // TODO falta método set isEatingGreen. Ver onde vai ser a invocação do método
    }

    public boolean isEatingRed(List red) { //continuar quando tiver maçãs //implementar metodo compare nas macas


        ServerPosition head = new ServerPosition(positionList.get(0).getColumn(), positionList.get(0).getRow());

        for (ServerPosition position : positionList) {
            if (apple.compare(position)) {
                return isEatingRed = true;
            }
        }
        return isEatingRed = false; // TODO falta método set isEatingRed. Ver onde vai ser a invocação do método
    }

    public void setGreenFalse() {
        isEatingGreen = false;
    }

    public void setRedFalse() {
        isEatingRed = false;
    }

    public String getName() {
        return name;
    }

    public void setOver() { //nao sei se vai ser necessario
        over = true;

    }


}
