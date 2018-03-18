package org.academiadecodigo.haltistas.AwesomeGame.server;

public class ServerPosition {

    public static final int MIN_COLUNM = 0;
    public static final int MAX_COLUNM = 59;
    public static final int MIN_ROW = 0;
    public static final int MAX_ROW = 39;

    private int column;
    private int row;

    public ServerPosition (int column, int row) {

        this.column = column;
        this.row = row;
    }

    public void moveUP() {
        row --;
    }

    public void moveDown() {
        row ++;
    }

    public void moveLeft() {
        column --;
    }

    public void moveRight() {
        column ++;
    }


    @Override
    public boolean equals(Object o) {

        if(o instanceof ServerPosition) {

            ServerPosition p = (ServerPosition) o;
            return p.column == this.column && p.row == this.row;
        }
        return false;
    }


    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
