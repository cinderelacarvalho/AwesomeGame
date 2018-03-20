package org.academiadecodigo.haltistas.AwesomeGame.server;

import org.academiadecodigo.haltistas.AwesomeGame.server.apple.Apple;
import org.academiadecodigo.haltistas.AwesomeGame.server.apple.AppleFactory;
import org.academiadecodigo.haltistas.AwesomeGame.server.apple.AppleType;

import java.util.LinkedList;
import java.util.List;

public class ServerGrid {


    private Server server;
    private Snake snake1;
    private Snake snake2;
    private Boolean over;
    private AppleFactory appleFactory;
    private List<Apple> applesList;
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

        for (int i = 0; i < INITIAL_APPLES; i++) {

            applesList.add(appleFactory.getNewApple());

            AppleType type = applesList.get(i).getType();
            String kind = type.toString();
            int col = applesList.get(i).getPosition().getColumn();
            int row = applesList.get(i).getPosition().getRow();

            server.broadcast("kind-" + row + col);

        }

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

            // lógica da movimentação da snake1 para as 3 situações
            if (snake1.getIsEatingGreen()) {

                server.broadcast(snake1.move());
                snake1.setGreenFalse();
            }

            if (!snake1.getIsEatingGreen() && !snake1.getIsEatingRed()) {

                server.broadcast(snake1.move());
                server.broadcast(snake1.deleteLast());
            }

            if (snake1.getIsEatingRed()) {

                server.broadcast(snake1.move());
                server.broadcast(snake1.deleteLast());
                server.broadcast(snake1.deleteLast());
                snake1.setRedFalse();
            }

            // lógica da movimentação da snake2 para as 3 situações
            if (snake2.getIsEatingGreen()) {

                server.broadcast(snake1.move());
                snake2.setGreenFalse();
            }

            if (!snake2.getIsEatingGreen() && !snake2.getIsEatingRed()) {

                server.broadcast(snake2.move());
                server.broadcast(snake2.deleteLast());
            }

            if (snake2.getIsEatingRed()) {

                server.broadcast(snake2.move());
                server.broadcast(snake2.deleteLast());
                server.broadcast(snake2.deleteLast());
                snake2.setRedFalse();
            }

            snake1.checkCollision(snake2);
            snake1.checkCollision(snake2);

            for (int i = 0; i < ROUND_APPLES; i++) {

                Apple apple= new Apple(appleFactory.getNewApple().getPosition().getColumn(),appleFactory.getNewApple().getPosition().getRow(), appleFactory.getNewApple().getType());

                //OU fazer pelo counter;

            }
        }

    }

    public void setOver(String name) {
        over = true;
        server.broadcast("gameover-" + name);
    }


}
