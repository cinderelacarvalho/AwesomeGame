package org.academiadecodigo.haltistas.AwesomeGame.server;

public class ServerGrid {


    private Server server;
    private Snake snake1;
    private Snake snake2;
    //private AppleFactory appleFactory;

    public ServerGrid(Server server) {

        this.server = server;
    }



    //todo método que envia a mensagem de start para cada um dos players.
    public void init() {
        server.broadcast("start");
    }

    //todo começa as movimentações. Enviar para os jogadores.
    public void start() {

        //todo thread para a cada ciclo de while movimentar
        server.broadcast("move");


    }

    //recebe mensagem do server para alterar direcção
    public void receiveMsg(String msg){

        System.out.println(msg);

    }


}
