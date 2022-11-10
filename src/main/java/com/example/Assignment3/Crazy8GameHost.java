package com.example.Assignment3;

public class Crazy8GameHost {
    private Crazy8Player[] players;
    protected int winningScore = 100;
    CardDeck deck;
    Card discardPile;

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

    protected void setDiscardPile(Card topCard){
        discardPile = topCard;
    }
    protected Card getDiscardPile(){
        return discardPile;
    }

    protected int playCard(Crazy8Player player, Card playedCard){

        //Check if it matches suit or Rank
        boolean canPlay = false;
        if((playedCard.cardSuit == discardPile.cardSuit) || (playedCard.cardRank == discardPile.cardRank)){
            canPlay = true;
        }

        //TODO: Add the special cards 8, Queen, ACE and TWO

        if(canPlay){
            setDiscardPile(playedCard);
            player.removeCard(playedCard);
            return 1;
        } else {
            return 0;
        }
    }

}
