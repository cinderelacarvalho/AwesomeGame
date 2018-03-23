package org.academiadecodigo.haltistas.AwesomeGame.server.apple;

import org.academiadecodigo.haltistas.AwesomeGame.server.Server;
import org.academiadecodigo.haltistas.AwesomeGame.server.ServerPosition;

public class AppleFactory {

    public Apple getNewApple() {

        int col = (int) Math.floor(Math.random() * ServerPosition.MAX_COLUMN - ServerPosition.MIN_COLUMN) + ServerPosition.MIN_COLUMN;
        int row = (int) Math.floor(Math.random() * ServerPosition.MAX_ROW - ServerPosition.MIN_ROW) + ServerPosition.MIN_ROW;

        ServerPosition position = new ServerPosition(col, row);
        int random = (int) (Math.random() * AppleType.values().length);

        AppleType appleType = AppleType.values()[random];

        Apple apple = null;

        switch (appleType) {

            case RED:
                apple = new Apple(position, appleType);
                break;

            case GREEN:
                apple = new Apple(position, appleType);
                break;

            default:
                System.out.println("Apple factory Error!");

        }

        return apple;
    }
}
