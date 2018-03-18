package tester;

public class ServerGrid {


    public void init() throws InterruptedException {

        // lado do cliente
        Grid grid = new Grid();

        // lado do cliente
        grid.init();

        Snake snake1 = new Snake("s1", new ServerPosition(20, 30), new ServerPosition(20, 31), new ServerPosition(20, 32));
        Snake snake2 = new Snake("s2", new ServerPosition(80, 30), new ServerPosition(80, 31), new ServerPosition(80, 32));

        Thread.sleep(1000);
        String string1 = snake1.move(Case.RIGHT);
        String string2 = snake2.move(Case.LEFT);
        System.out.println(string1 + " " + string2);


    }


}
