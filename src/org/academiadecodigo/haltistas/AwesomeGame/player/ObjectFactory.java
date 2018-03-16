package org.academiadecodigo.haltistas.AwesomeGame.player;

import sun.security.krb5.internal.PAData;

public class ObjectFactory {


    public static PlayerPosition getGreenAplle(int row, int col) {
        return null;
    }

    public static PlayerPosition getRedApple(int row, int col) {
        return null;
    }

    public static void getWall() {
        int i = 0;
        while (i < 60) {
            i++;
            new PlayerPosition(49, i).drawPos();
            new PlayerPosition(50, i).drawPos();
        }

    }


}
