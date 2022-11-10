package com.example.Assignment3;

public class Crazy8Player {

    Card[] playerHand;

    int score;
     private int playerNum;

    public Crazy8Player(int playerNumber){
        playerNum = playerNumber;
        score = 0;
    }

    public void setPlayerHand(Card[] hand){
        playerHand = hand;
    }

    public Card[] getPlayerHand(){
        return playerHand;
    }

    public void removeCard(Card remove){
        Card[] newHand = new Card[playerHand.length -1];
        int j = 0;
        for(int i = 0; i < playerHand.length; i++){
            if((playerHand[i].cardRank == remove.cardRank) && (playerHand[i].cardSuit == remove.cardSuit)){

            } else{
                newHand[j] = playerHand[i];
                j++;
            }
        }
        playerHand = newHand;
    }

    public int getPlayerNum(){
        return playerNum;
    }


}
