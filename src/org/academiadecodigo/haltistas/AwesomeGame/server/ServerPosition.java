package org.academiadecodigo.haltistas.AwesomeGame.server;

public class ServerPosition {

    public static final int MIN_COLUMN = 0;
    public static final int MAX_COLUMN = 59;
    public static final int MIN_ROW = 0;
    public static final int MAX_ROW = 99;

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


    public boolean equals(ServerPosition o) {

        return o.column == this.column && o.row == this.row;
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
