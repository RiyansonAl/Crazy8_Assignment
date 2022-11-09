package com.example.Assignment3;

public class Crazy8Player {

    Card[] playerHand;

    int score;

    public Crazy8Player(){
        score = 0;
    }

    public void setPlayerHand(Card[] hand){
        playerHand = hand;
    }

    public Card[] getPlayerHand(){
        return playerHand;
    }


}
