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

    protected Card[] drawHand(Crazy8Player player, Card[] riggedHand){
        if(riggedHand[0].cardRank == Card.Rank.NONE){
            Card nullCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
            Card[] playerHand = new Card[5];
            for(int i = 0; i < 5; i++){
                playerHand[i] = drawCard(nullCard);
            }
            player.setPlayerHand(playerHand);
            return playerHand;
        } else{
            player.setPlayerHand(riggedHand);
            return riggedHand;
        }
    }

    protected String printHand(Crazy8Player player){
        Card[] playerHand = player.getPlayerHand();
        String handInString = "";
        for(int i = 0; i < playerHand.length-1; i++){
            handInString = handInString + playerHand[i].toString() + ",";
        }
        handInString = handInString + playerHand[playerHand.length-1].toString();

        return handInString;

    }

}
