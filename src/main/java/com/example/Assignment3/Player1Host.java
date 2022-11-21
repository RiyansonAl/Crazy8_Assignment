package com.example.Assignment3;

public class Player1Host {
    boolean allPlayersConnected;
    int numOfPlayers;

    public Player1Host(int numPlayers){
        allPlayersConnected = false;
        numOfPlayers = numPlayers;
    }

    public int getNumOfPlayers(){
        return numOfPlayers;
    }

    public void setNumOfPlayers(int num){
        numOfPlayers = num;
    }
}
