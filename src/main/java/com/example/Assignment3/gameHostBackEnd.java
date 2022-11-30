package com.example.Assignment3;

public class gameHostBackEnd {

    boolean allPlayersConnected;

    int numOfPlayers;
    Crazy8Player player1;
    Crazy8Player player2;
    Crazy8Player player3;
    Crazy8Player player4;

    Crazy8GameHost gameHost;

    public gameHostBackEnd(int numPlayers){
        allPlayersConnected = false;
        numOfPlayers = numPlayers;
    }

    public int getNumOfPlayers(){
        return numOfPlayers;
    }

    public void setNumOfPlayers(int num){
        numOfPlayers = num;
    }

    public int joinGame(){


        //Return the player number
        return 2;
    }

    //Loops until all the players join the game
    public void waitingForPlayers(){

    }
}
