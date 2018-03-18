package tester;

public class Main {

    public static void main(String[] args) {

        ServerGrid serverGrid = new ServerGrid();

        try {
            serverGrid.init();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
