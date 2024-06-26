package com.example.Assignment3;

import org.checkerframework.checker.units.qual.C;

public class Crazy8Player {

    Card[] playerHand;

    int score;
     private int playerNum;

    public Crazy8Player(int playerNumber){
        playerNum = playerNumber;
        score = 0;
        //Start off with a null hand
        Card nullCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
        playerHand = new Card[]{nullCard, nullCard, nullCard, nullCard, nullCard};
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
        if(newHand.length != 0) {
            for (int i = 0; i < playerHand.length; i++) {
                if ((playerHand[i].cardRank == remove.cardRank) && (playerHand[i].cardSuit == remove.cardSuit)) {

                } else {
                    newHand[j] = playerHand[i];
                    j++;
                }
            }
        }

        playerHand = newHand;
    }

    public void addCardToHand(Card add){
        Card[] newHand = new Card[playerHand.length + 1];
        for(int i = 0; i < playerHand.length; i++){
            newHand[i] = playerHand[i];
        }
        newHand[playerHand.length] = add;
        playerHand = newHand;
    }

    public int getPlayerNum(){
        return playerNum;
    }

    public int getNumOfCardsInHand(){
        return playerHand.length;
    }

    public void addScore(int UpdareScore){
        score = score + UpdareScore;
    }

    public int getScore(){
        return score;
    }


}
