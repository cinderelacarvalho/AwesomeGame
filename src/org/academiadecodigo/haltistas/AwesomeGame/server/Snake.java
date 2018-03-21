package org.academiadecodigo.haltistas.AwesomeGame.server;

import org.academiadecodigo.haltistas.AwesomeGame.server.apple.Apple;
import org.academiadecodigo.haltistas.AwesomeGame.server.apple.AppleType;

import java.util.LinkedList;
import java.util.List;

public class Snake {

    private List<ServerPosition> positionList;
    private String name;
    private boolean over;
    private Direction direction;
    private boolean isEatingApple;
    private boolean isEatingGreen;
    private boolean isEatingRed;
    private ServerGrid serverGrid;


    public Snake(String name, ServerPosition initial1, ServerPosition initial2, ServerPosition initial3, ServerGrid serverGrid) {

        this.name = name;
        this.serverGrid = serverGrid;
        direction = Direction.UP;
        positionList = new LinkedList<>();

        positionList.add(initial1);
        positionList.add(initial2);
        positionList.add(initial3);

    }

    public void setDirection(String msg) {

        if (msg.equals("up") && (direction.equals(Direction.RIGHT) || direction.equals(Direction.LEFT))) {
            direction = Direction.UP;
        }

        if (msg.equals("down") && (direction.equals(Direction.RIGHT) || direction.equals(Direction.LEFT))) {
            direction = Direction.DOWN;
        }

        if (msg.equals("left") && (direction.equals(Direction.UP)) || direction.equals(Direction.DOWN)) {
            direction = Direction.LEFT;
        }

        if (msg.equals("right") && (direction.equals(Direction.UP)) || direction.equals(Direction.DOWN)) {
            direction = Direction.RIGHT;
        }
        direction = direction;

    }

    public String move() {

        ServerPosition position = new ServerPosition(positionList.get(0).getColumn(), positionList.get(0).getRow());
        String msg = "";

        switch (direction) {

            case UP:

                position.moveUP();
                positionList.add(0, position);

                if (position.getRow() == ServerPosition.MIN_ROW) {
                    over = true;
                    serverGrid.setOver();
                }

                msg = "move-" + name + "-u";
                break;

            case DOWN:

                position.moveDown();
                positionList.add(0, position);

                if (position.getRow() == ServerPosition.MAX_ROW) {
                    over = true;
                    serverGrid.setOver();
                }

                msg = "move-" + name + "-d";
                break;

            case LEFT:

                position.moveLeft();
                positionList.add(0, position);

                if (position.getColumn() == ServerPosition.MIN_COLUMN) {
                    over = true;
                    serverGrid.setOver();
                }

                msg = "move-" + name + "-l";
                break;

            case RIGHT:

                position.moveRight();
                positionList.add(0, position);

                if (position.getColumn() == ServerPosition.MAX_COLUMN) {
                    over = true;
                    serverGrid.setOver();
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

        positionList.remove(positionList.size() - 1);

        String delete = "delete" + "-" + name;
        return delete;
    }

    public void checkCollision(Snake snake) {

        ServerPosition head = new ServerPosition(positionList.get(0).getColumn(), positionList.get(0).getRow());

        for (ServerPosition position : snake.positionList) {

            if (head.equals(position)) {
                System.out.println("HIIIIIIIT");
                over = true;
            }
        }

    }

    public boolean isEatingApple(Apple apple) {


        ServerPosition head = new ServerPosition(positionList.get(0).getColumn(), positionList.get(0).getRow());

        if (apple.compare(head)) {
            AppleType type = apple.getType();

            switch(type) {

                case RED:
                    isEatingRed = true;
                    isEatingApple = true;
                    break;

                case GREEN:
                    isEatingGreen = true;
                    isEatingApple = true;
                    break;

                default:
                    System.out.println("Apple colliding snake error");
            }
        }
        return isEatingApple;
    }

    public void setEatingAppleFalse() {
        isEatingApple = false;
    }

    public void setIsEatingGreenFalse() {
        isEatingGreen = false;
    }

    public void setIsEatingRedFalse() {
        isEatingRed = false;
    }

    public boolean getIsEatingGreen() {
        return isEatingGreen;
    }

    public boolean getIsEatingRed() {
        return isEatingRed;
    }

    public boolean getIsEatingApple() {
        return isEatingApple;
    }

    public String getName() {
        return name;
    }

    public void setOver() {
        over = true;
        serverGrid.setOver();
        serverGrid.setOver(name);

    }



}
