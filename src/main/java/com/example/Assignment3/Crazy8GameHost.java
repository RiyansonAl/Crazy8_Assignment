package com.example.Assignment3;

public class Crazy8GameHost {
    private Crazy8Player[] players;
    protected int roundEndingScore = 100;
    CardDeck deck;
    Card discardPile;

    protected Crazy8Player currentPlayer;
    protected boolean fwdTurnOrder;
    protected boolean skipNextTurn;


    public Crazy8GameHost(Crazy8Player[] newplayers){

        players = newplayers;
        deck = new CardDeck();
        currentPlayer = newplayers[0];
        fwdTurnOrder = true;
        skipNextTurn = false;
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

    protected int playCard(Crazy8Player player, Card playedCard, Card.Suit cardSuit){

        //Check if it matches suit or Rank
        boolean canPlay = false;
        if((playedCard.cardSuit == discardPile.cardSuit) || (playedCard.cardRank == discardPile.cardRank)){
            canPlay = true;
        }

        //TODO: Add the special cards 8, Queen, ACE and TWO
        if(playedCard.cardRank == Card.Rank.EIGHT){
            Card suitCard = new Card(Card.Rank.NONE, cardSuit);
            setDiscardPile(suitCard);
            player.removeCard(playedCard);
            return 1;
        }

        if(canPlay){
            setDiscardPile(playedCard);
            player.removeCard(playedCard);
            return 1;
        } else {
            return 0;
        }
    }

    protected Crazy8Player getNextPlayer(){
        int currentPlayerNum = currentPlayer.getPlayerNum();
        int numOfPlayers = players.length;

        int nextPlayerNum = 0;
        if(fwdTurnOrder == true){
            //Skip next players turn
            if(skipNextTurn){
                //Adding 1 here since currentPlayerNum is already one greater than array position
                nextPlayerNum = currentPlayerNum + 1;
                if(nextPlayerNum == numOfPlayers){
                    nextPlayerNum = 0;
                } else if (nextPlayerNum > nextPlayerNum){
                    nextPlayerNum = 1;
                }
                skipNextTurn = false;
            } else {
                //not adding anything here since currentPlayerNum is already one greater than array position
                nextPlayerNum = currentPlayerNum;
                if (nextPlayerNum >= numOfPlayers) {
                    nextPlayerNum = 0;
                }
            }
            currentPlayer = players[nextPlayerNum];
            return players[nextPlayerNum];

        } else{
            //Reverse order
            if(skipNextTurn){
                nextPlayerNum = currentPlayerNum - 3;
                if(nextPlayerNum == -1){
                    nextPlayerNum = numOfPlayers -1;
                } else if(nextPlayerNum == -2){
                    nextPlayerNum = numOfPlayers -2;
                }
                skipNextTurn = false;
            } else {
                //Not skipping a turn
                //-2 since currentPlayerNum is one number ahead
                nextPlayerNum = currentPlayerNum - 2;
                if(nextPlayerNum < 0){
                    nextPlayerNum = numOfPlayers-1;
                }
            }
            currentPlayer = players[nextPlayerNum];
            return players[nextPlayerNum];
        }
    }

}
