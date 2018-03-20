package org.academiadecodigo.haltistas.AwesomeGame.server;

public class ServerLauncher {

    public static void main(String[] args) {

        //create new server // server.init

        Server server= new Server(8765);

        server.start();


        System.out.println("Beginning of AwesomeGame journey.");
    }
}
