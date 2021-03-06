package org.academiadecodigo.haltistas.AwesomeGame.server;

import org.academiadecodigo.haltistas.AwesomeGame.server.apple.Apple;
import org.academiadecodigo.haltistas.AwesomeGame.server.apple.AppleFactory;
import org.academiadecodigo.haltistas.AwesomeGame.server.apple.AppleType;

import java.util.*;

public class ServerGrid implements Runnable {


    private Server server;
    private volatile boolean over;
    private Timer timer;

    private LinkedList<ServerPosition> wallList;
    private int wallClockCounter = 0;

    private AppleFactory appleFactory;
    private LinkedList<Apple> applesList;
    private static final int INITIAL_APPLES = 40;
    private static final int ROUND_APPLES = 1;
    private final int wallCol1 = 49;
    private final int wallCol2 = 50;

    private ArrayList<Snake> snakeList;
    private Snake snake1;
    private Snake snake2;
    private int initialColSnake1 = 24;
    private int initialColSnake2 = 75;
    private int initialRowSnakes = 30;


    public ServerGrid(Server server) {

        this.server = server;
        applesList = new LinkedList<>();
        appleFactory = new AppleFactory();
        wallList = new LinkedList<>();
        timer = new Timer();

    }

    @Override
    public void run() {
        init();
    }

    private void init() {


        synchronized (this) {

            while (server.notEnoughPlayers()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
        prepare();
    }

    private void prepare() {

        over = false;
        snakeList = new ArrayList<>();

        snake1 = new Snake("0", new ServerPosition(initialColSnake1, initialRowSnakes),
                new ServerPosition(initialColSnake1, initialRowSnakes + 1),
                new ServerPosition(initialColSnake1, initialRowSnakes + 2));
        snakeList.add(snake1);
        snake1.setMinCol(ServerPosition.MIN_COLUMN);
        snake1.setMaxCol(48);

        snake2 = new Snake("1", new ServerPosition(initialColSnake2, initialRowSnakes),
                new ServerPosition(initialColSnake2, initialRowSnakes + 1),
                new ServerPosition(initialColSnake2, initialRowSnakes + 2));
        snakeList.add(snake2);
        snake2.setMinCol(51);
        snake2.setMaxCol(ServerPosition.MAX_COLUMN);

        server.broadcast("start");

        getWall();

        getNewApple(INITIAL_APPLES);

        start();
    }

    public void receiveMsg(String msg) {

        if (over) {
            server.broadcast("restart");
            prepare();
            return;
        }

        String[] words = msg.split("-");
        int numSnake = Integer.parseInt(words[0]);
        snakeList.get(numSnake).setDirection(words[1]);
    }

    private void start() {


        class MyVerySpecialTask extends TimerTask {
            @Override
            public void run() {

                wallClockCounter++;

                if (wallClockCounter == 100) {

                    server.broadcast("deletewall");
                    snake1.setMaxCol(ServerPosition.MAX_COLUMN);
                    snake2.setMinCol(ServerPosition.MIN_COLUMN);
                }

                checkEatingApple(applesList);

                isSnakeEatingGreen(snake1);
                isSnakeNotEating(snake1);
                isSnakeEatingRed(snake1);

                isSnakeEatingGreen(snake2);
                isSnakeNotEating(snake2);
                isSnakeEatingRed(snake2);

                snake1.checkCollision(snake2);
                snake2.checkCollision(snake1);

                if (applesList.size() < 10) {
                    getNewApple(ROUND_APPLES);
                }

                if (snake1.getIsOver()) {
                    setOver(snake1);
                }

                if (snake2.getIsOver()) {
                    setOver(snake2);
                }

                if (over) {
                    cancel();
                }
            }
        }
        timer.scheduleAtFixedRate(new MyVerySpecialTask(), 0, 350);
    }

    private void checkEatingApple(LinkedList<Apple> applesList) {

        Iterator<Apple> iterator = applesList.iterator();

        while (iterator.hasNext()) {
            Apple apple = iterator.next();

            snake1.isEatingApple(apple);
            snake2.isEatingApple(apple);

            if (snake1.getIsEatingApple() || snake2.getIsEatingApple()) {

                int col = apple.getPosition().getColumn();
                int row = apple.getPosition().getRow();

                server.broadcast("deleteapple-" + row + "-" + col);

                iterator.remove();
                snake1.setEatingAppleFalse();
                snake2.setEatingAppleFalse();
            }
        }
    }

    private void isSnakeEatingGreen(Snake snake) {

        if (snake.getIsEatingGreen()) {

            server.broadcast(snake.move());
            snake.setIsEatingGreenFalse();
        }
    }

    private void isSnakeNotEating(Snake snake) {

        if (!snake.getIsEatingGreen() && !snake.getIsEatingRed()) {

            server.broadcast(snake.move());
            server.broadcast(snake.deleteLast());
        }
    }

    private void isSnakeEatingRed(Snake snake) {

        if (snake.getIsEatingRed()) {

            server.broadcast(snake.move());
            server.broadcast(snake.deleteLast());
            server.broadcast(snake.deleteLast());
            snake.setIsEatingRedFalse();
        }

    }

    private void getWall() {

        for (int i = ServerPosition.MIN_ROW; i <= ServerPosition.MAX_ROW; i++) {

            wallList.add(new ServerPosition(wallCol1, i));
            wallList.add(new ServerPosition(wallCol2, i));
        }

    }

    private void getNewApple(int number) {

        for (int i = 0; i < number; i++) {

            Apple apple = (appleFactory.getNewApple());

            while (isOccupied(apple.getPosition())) {
                apple = appleFactory.getNewApple();
            }

            applesList.add(apple);
            server.broadcast(applesList.getLast().toString());
        }
    }

    private boolean isOccupied(ServerPosition position) {

        for (ServerPosition wall : wallList) {
            if (wall.equals(position)) {
                return true;
            }
        }

        for (Apple apple : applesList) {
            if (apple.hasPosition(position)) {
                return true;
            }
        }
        return snake1.hasPosition(position) || snake2.hasPosition(position);
    }

    private void setOver(Snake snake) {

        over = true;
        server.broadcast("over-" + snake.getName());
        applesList.clear();
        snake1.positionList.clear();
        snake2.positionList.clear();

    }

    @Override
    public String toString() {
        return "ServerGrid{" +
                "applesList=" + applesList +
                ", snakeList=" + snakeList +
                '}';
    }
}
