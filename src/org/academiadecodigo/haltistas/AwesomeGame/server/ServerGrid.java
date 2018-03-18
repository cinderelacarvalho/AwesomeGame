package org.academiadecodigo.haltistas.AwesomeGame.server;

public class ServerGrid {


    private Server server;
    private Snake snake1;
    private Snake snake2;
    //private AppleFactory appleFactory;

    public ServerGrid(Server server) {

        this.server = server;
    }



    //Método que envia a mensagem de start para cada um dos players.
    //TODO uma threadSleep? para esperar um pouco até começar?
    public void init() {

        snake1 = new Snake("s1", new ServerPosition(20,30), new ServerPosition(20,31), new ServerPosition(20,32));
        snake2 = new Snake("s2", new ServerPosition(80,30), new ServerPosition(80, 31), new ServerPosition(80,32));
        server.broadcast("start-0-0");
        start();

    }

    //recebe mensagem do server para alterar direcção
    public void receiveMsg(String msg){

        snake1.setDirection(msg);
        snake2.setDirection(msg);

    }

    //TODO começa as movimentações. Enviar para os jogadores.

    public void start() {

        //TODO thread para a cada ciclo de while movimentar


        //TODO  se colidiu com maca verde Move().Este método via receber uma snake

        server.broadcast(snake1.move());
        server.broadcast(snake2.move());

        //TODO se nao colidiu com macas move() + deleteLast()

        server.broadcast(snake1.deleteLast());
        server.broadcast(snake2.deleteLast());

        //TODO se colidiu com maca vermelha move() + deleteLast() + deleteLast

        server.broadcast(snake1.deleteLast());
        server.broadcast(snake2.deleteLast());


    }


}
