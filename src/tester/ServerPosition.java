package tester;

public class ServerPosition {

    private int column;
    private int row;

    public ServerPosition (int column, int row) {

        this.column = column;
        this.row = row;
    }


    @Override
    public boolean equals(Object o) {
        if(o instanceof ServerPosition) {
            ServerPosition p = (ServerPosition) o;
            return p.column == this.column && p.row == this.row;
        }
        return false;
    }
}
