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
        server.broadcast("start");
        start();

    }

    //TODO começa as movimentações. Enviar para os jogadores.
    public void start() {

        //TODO thread para a cada ciclo de while movimentar
        server.broadcast("move");


    }

    //recebe mensagem do server para alterar direcção
    public void receiveMsg(String msg){

        System.out.println(msg);

    }


}
