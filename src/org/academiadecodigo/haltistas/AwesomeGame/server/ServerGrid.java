package org.academiadecodigo.haltistas.AwesomeGame.server;

import org.academiadecodigo.haltistas.AwesomeGame.server.apple.Apple;
import org.academiadecodigo.haltistas.AwesomeGame.server.apple.AppleFactory;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class ServerGrid implements Runnable{


    private Server server;
    private Snake snake1;
    private Snake snake2;
    private boolean over;
    private AppleFactory appleFactory;
    private LinkedList<Apple> applesList;
    private static final int INITIAL_APPLES = 3;
    private static final int ROUND_APPLES = 1;
    private Timer timer;


    public ServerGrid(Server server) {

        this.server = server;
        applesList = new LinkedList<>();
        appleFactory = new AppleFactory();
        timer = new Timer();
    }

    @Override
    public void run() {
        init();
    }

    //Método que envia a mensagem de start para cada um dos players.
    public void init() {


        synchronized (this) {

            while (!server.notEnoughPlayers()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
        snake1 = new Snake("0", new ServerPosition(20, 30), new ServerPosition(20, 31),
                new ServerPosition(20, 32), this);

        snake2 = new Snake("1", new ServerPosition(80, 30), new ServerPosition(80, 31),
                new ServerPosition(80, 32), this);

        server.broadcast("start");

        getNewApple(INITIAL_APPLES);

        start();

    }

    //recebe mensagem do server para alterar direcção
    public void receiveMsg(String msg) {

        //if is player 1 do snake 1, player 2 do snake 2 setDirection
        snake1.setDirection(msg);
        snake2.setDirection(msg);

    }

    //começa as movimentações.
    public void start() {

        class MyVerySpecialTask extends TimerTask {
            @Override
            public void run() {

                // verifica se está a comer maçãs e qual
                checkEatingApple(applesList);

                // lógica da movimentação da snake1 para as 3 situações
                isSnakeEatingGreen(snake1);
                isSnakeNotEating(snake1);
                isSnakeEatingRed(snake1);

                // lógica da movimentação da snake2 para as 3 situações
                isSnakeEatingGreen(snake2);
                isSnakeNotEating(snake2);
                isSnakeEatingRed(snake2);

                snake1.checkCollision(snake2);
                snake2.checkCollision(snake1);

                getNewApple(ROUND_APPLES);
            }
        }

        timer.scheduleAtFixedRate(new MyVerySpecialTask(),0, 1000);



    }

    private void checkEatingApple (LinkedList<Apple> applesList) {

        for (Apple apple : applesList) {  //TODO verificar se o metodo fuciona

            snake1.isEatingApple(apple);
            snake2.isEatingApple(apple);

            if (snake1.getIsEatingApple() || snake2.getIsEatingApple()) {

                int col = apple.getPosition().getColumn();
                int row = apple.getPosition().getRow();

                server.broadcast("deleteapple-" + row + col);
                applesList.remove(apple);
                snake1.setEatingAppleFalse();
                snake2.setEatingAppleFalse();
            }

        }
    }

    private void isSnakeEatingGreen(Snake snake) {

        if(snake.getIsEatingGreen()) {

            server.broadcast(snake.move());
            snake.setIsEatingGreenFalse();
        }
    }

    private void isSnakeNotEating(Snake snake) {

        if(!snake.getIsEatingGreen() && !snake.getIsEatingRed()) {

            server.broadcast(snake.move());
            server.broadcast(snake.deleteLast());
        }
    }

    private void isSnakeEatingRed(Snake snake) {

        if(snake.getIsEatingRed()) {

            server.broadcast(snake.move());
            server.broadcast(snake.deleteLast());
            server.broadcast(snake.deleteLast());
            snake.setIsEatingRedFalse();
        }

    }

    private void getNewApple(int number) {

        for (int i = 0; i < number; i++) {

            applesList.add(appleFactory.getNewApple());
            server.broadcast(applesList.getLast().toString());

        }
    }


    public void setOver(String name) {
        over = true;
        server.broadcast("gameover-" + name);
    }


}
