package tester;

public class ServerGrid {


    public void init() {

        Grid grid = new Grid();

        grid.init();

        Snake snake = new Snake(new ServerPosition(5, 6));

    }
}
