package org.academiadecodigo.haltistas.AwesomeGame.server;

import org.academiadecodigo.haltistas.AwesomeGame.server.apple.Apple;
import org.academiadecodigo.haltistas.AwesomeGame.server.apple.AppleFactory;

import java.util.LinkedList;
import java.util.List;

public class ServerGrid {


    private Server server;
    private Snake snake1;
    private Snake snake2;
    private Boolean over;
    private AppleFactory appleFactory;
    private LinkedList<Apple> applesList;
    private static final int INITIAL_APPLES = 40;
    private static final int ROUND_APPLES = 10;


    public ServerGrid(Server server) {

        this.server = server;
        applesList = new LinkedList<>();
        appleFactory = new AppleFactory();
    }


    //Método que envia a mensagem de start para cada um dos players.
    //TODO uma threadSleep? para esperar um pouco até começar?
    public void init() {

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

        snake1.setDirection(msg);
        snake2.setDirection(msg);

    }

    //começa as movimentações.
    public void start() {


        //TODO thread para a cada ciclo de while movimentar. Aplicar timer???? como???
        while (!over) {

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

    private void checkEatingApple (LinkedList<Apple> applesList) {

        for (Apple apple : applesList) {  //TODO verificar se o metodo fuciona

            Boolean eatingApple1 = snake1.isEatingApple(apple);
            Boolean eatingApple2 = snake2.isEatingApple(apple);

            if (eatingApple1 || eatingApple2) {

                int col = apple.getPosition().getColumn();
                int row = apple.getPosition().getRow();

                server.broadcast("deleteapple-" + row + col);
                applesList.remove(apple);
            }

        }
    }

    private void isSnakeEatingGreen(Snake snake) {

        if(snake.getIsEatingGreen()) {

            server.broadcast(snake.move());
            snake.setGreenFalse();
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
            snake.setRedFalse();
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
