package org.academiadecodigo.haltistas.AwesomeGame.player;

import java.io.IOException;

public class PlayerLauncher {

    public static void main(String[] args) {

        PlayerNetwork playerNetwork = null;
        try {

            if (args.length != 2) {
                System.out.println("Usage: java -jar ServerLauncher <Hostname> <PortNumber>");
                return;
            }
            String hostname=args[0];
            int portNumber=Integer.parseInt(args[1]);


            playerNetwork = new PlayerNetwork(hostname, portNumber);
            playerNetwork.init();

            Thread thread = new Thread(playerNetwork);
            thread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
