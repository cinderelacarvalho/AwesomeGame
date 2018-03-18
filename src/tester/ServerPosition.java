package tester;

public class ServerPosition {

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

    //cenas do lado do cliente


    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
