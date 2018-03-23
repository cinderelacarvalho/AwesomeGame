package org.academiadecodigo.haltistas.AwesomeGame.server;

public class ServerLauncher {

    public static void main(String[] args) {


        if (args.length != 1) {
            System.out.println("Usage: java -jar ServerLauncher <PortNumber>");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server server = new Server(port);
        server.start();

        System.out.println("Beginning of AwesomeGame journey.");
    }
}
