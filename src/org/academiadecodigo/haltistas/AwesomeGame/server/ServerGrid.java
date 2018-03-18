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

        snake1.move(msg);
        snake2.move(msg);

    }

    //TODO começa as movimentações. Enviar para os jogadores.

    public void start() {

        //TODO thread para a cada ciclo de while movimentar
        //TODO tratar a mensagem...





        server.broadcast("lkasdjflksjakl");


    }


}
