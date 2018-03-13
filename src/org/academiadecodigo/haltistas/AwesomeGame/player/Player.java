package org.academiadecodigo.haltistas.AwesomeGame.player;

import java.io.*;
import java.net.Socket;

public class Player implements Runnable{

    private int portNumber;
    private String hostName;
    private Socket playerSocket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    public Player(String hostName, int portNumber){
        this.hostName=hostName;
        this.portNumber=portNumber;
    }

    public void init() {


        try {
            playerSocket = new Socket(hostName,portNumber);
            bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(playerSocket.getOutputStream()));
            bufferedReader=new BufferedReader(new InputStreamReader(playerSocket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendMsg(){

    }




    // this method as 1 thread

    @Override
    public void run() {

    }
}
