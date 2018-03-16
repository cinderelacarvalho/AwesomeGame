package org.academiadecodigo.haltistas.AwesomeGame.server;

public class ServerGrid {

    private Grid grid;


    public void init() {

        grid = new Grid();

    }


    public void receiveMsg(String msg){

        System.out.println(msg);

    }


}
