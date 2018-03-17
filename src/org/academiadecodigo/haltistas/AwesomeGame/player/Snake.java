package org.academiadecodigo.haltistas.AwesomeGame.player;

import java.util.LinkedList;

public class Snake {

    private PlayerPosition position;
    private LinkedList<PlayerPosition> snakePositionP1;
    private LinkedList<PlayerPosition> snakePositionP2;

    public Snake() {
        snakePositionP1 = new LinkedList<>();
        snakePositionP2 = new LinkedList<>();
    }

    public void initialSnakeP1(PlayerPosition position) {
        snakePositionP1.add(position);
        position.paintPos();

    }

    public void initialSnakeP2(PlayerPosition position) {
        snakePositionP2.add(position);
        position.paintPos();

    }

}

