package org.academiadecodigo.haltistas.AwesomeGame.server;

public class ServerPosition {

    public static int MIN_COLUMN = 0; // TODO: to shrink we need to change these values
    public static final int MAX_COLUMN = 99;
    public static int MIN_ROW = 0;
    public static final int MAX_ROW = 59;

    public static synchronized void shrink() {
        System.err.println("\t\t\t\t\t SHRINK BOY");
        MIN_ROW++;
        MIN_COLUMN++;
    }

    private int column;
    private int row;

    public ServerPosition(int column, int row) {

        this.column = column;
        this.row = row;
    }

    public void moveUP() {
        row--;
    }

    public void moveDown() {
        row++;
    }

    public void moveLeft() {
        column--;
    }

    public void moveRight() {
        column++;
    }


    @Override
    public boolean equals(Object o) {

        if (o instanceof ServerPosition) {
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

    @Override
    public String toString() {
        return "ServerPosition{" +
                "column=" + column +
                ", row=" + row +
                '}';
    }
}
