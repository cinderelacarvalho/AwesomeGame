package org.academiadecodigo.haltistas.AwesomeGame.server;

import java.util.List;

public class ServerGrid {


    private Server server;
    private Snake snake1;
    private Snake snake2;
    private Boolean over;
    //private AppleFactory appleFactory;
    //private List<RedApple> redList;
    //private List<GreenApple> greenList;

    public ServerGrid(Server server) {
        this.server = server;
        //redList = new Linked...
        //greenList = new Linked...
    }


    //Método que envia a mensagem de start para cada um dos players.
    //TODO uma threadSleep? para esperar um pouco até começar?
    public void init() {

        snake1 = new Snake("s1", new ServerPosition(20, 30), new ServerPosition(20, 31), new ServerPosition(20, 32));
        snake2 = new Snake("s2", new ServerPosition(80, 30), new ServerPosition(80, 31), new ServerPosition(80, 32));
        server.broadcast("start-0-0");
        start();

    }

    //recebe mensagem do server para alterar direcção
    public void receiveMsg(String msg) {

        snake1.setDirection(msg);
        snake2.setDirection(msg);

    }

    //começa as movimentações.
    public void start() {

        //TODO apple Factory criar macãs 40.. metodos separados para guardar maças nas listas respectivas e fazer broadcast das posicoes geradas.


        //TODO thread para a cada ciclo de while movimentar. Aplicar timer???? como???
        while (!over) {

            if (snake1)

            if (snake1.isColliding(snake2)) {
                setOver(snake1); //falta buscar a snake vencedora. esta é para teste.
                return;
            }

            snake1.isEatingGreen(greenList); //return apple para apagar da lista (criar metodo apagar da lista e fazer broadcast)
            snake1.isEatingRed(redList);
            snake2.isEatingGreen(greenList);
            snake2.isEatingRed(redList);


            //TODO apple Factory criar macãs.. metodos separados para guardar maças nas listas respectivas


            //TODO  if (snake.isEatingGreen)
            server.broadcast(snake1.move());
            snake1.setGreenFalse();

            //TODO if (!snake.isEatingRed && !snake.isEatingGreen)
            server.broadcast(snake1.move());
            server.broadcast(snake1.deleteLast());

            //TODO is (snake.isEatingRed)
            server.broadcast(snake1.move());
            server.broadcast(snake1.deleteLast());
            server.broadcast(snake1.deleteLast());
            snake1.setRedFalse();


        }


    }


    public void setOver(Snake snake) {
        over = true;
        server.broadcast("gameover-" + snake.getName() + "-0");
    }


}
