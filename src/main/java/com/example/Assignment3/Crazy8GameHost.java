package com.example.Assignment3;

public class Crazy8GameHost {
    private Crazy8Player[] players;
    protected int winningScore = 100;
    CardDeck deck;

    public Crazy8GameHost(Crazy8Player[] newplayers){

        players = newplayers;
        deck = new CardDeck();
    }

    protected Card drawCard (Card riggedCard){

        return deck.drawCard(riggedCard);
    }
}
