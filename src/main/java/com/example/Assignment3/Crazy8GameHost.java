package com.example.Assignment3;

import java.util.regex.Pattern;

public class Crazy8GameHost {
    Crazy8Player[] players;
    protected int gameEndingScore = 100;
    CardDeck deck;
    Card discardPile;

    protected Crazy8Player currentPlayer;
    protected boolean fwdTurnOrder;
    protected boolean skipNextTurn;
    protected boolean play2Cards;
    protected boolean roundEnded;
    protected boolean gameover;
    protected int currentPlayerCardDrawn;
    protected Card lastDrawnCard;
    protected  int lastPlayerNum;
    protected boolean lastPlayerTurnSkipped;
    protected int lastCard2;
    protected boolean play2cardsNextPlayer;


    public Crazy8GameHost(Crazy8Player[] newplayers){

        players = newplayers;
        deck = new CardDeck();
        currentPlayer = newplayers[0];
        fwdTurnOrder = true;
        skipNextTurn = false;
        play2Cards = false;
        roundEnded = false;
        gameover = false;
        lastPlayerTurnSkipped = false;
        lastPlayerNum = 0;
        currentPlayerCardDrawn = 0;
        lastCard2 = 0;
        play2cardsNextPlayer = false;
        lastDrawnCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
    }

    protected Card playerDrawCard (Card riggedCard){
        Card drawnCard = deck.drawCard(riggedCard);
        currentPlayer.addCardToHand(drawnCard);
        return drawnCard;
    }

    //TODO: Player draws card and can only play this drawn card or they will have to pick up, up to 3 cards and end turn
    protected Card playerChoosesToDrawCard (Card riggedCard){
        Card drawnCard = playerDrawCard(riggedCard);
        //If same current player need to increase counter for drawn cards
        currentPlayerCardDrawn = currentPlayerCardDrawn + 1;
        lastDrawnCard = drawnCard;
        //Check to see if the drawn card can be played. If not then prompt to draw another card or automatically draw another card

        return drawnCard;
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

    protected void newRound(){
        deck = new CardDeck();
        currentPlayer = players[0];
        fwdTurnOrder = true;
        skipNextTurn = false;
        play2Cards = false;
        roundEnded = false;
        currentPlayerCardDrawn = 0;
        lastCard2 = 0;
        play2cardsNextPlayer = false;
        lastDrawnCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
    }

    protected String getPlayerHand(int playerNum){
        return this.printHand(players[playerNum-1]);
    }

    protected String printHand(Crazy8Player player){
        Card[] playerHand = player.getPlayerHand();
        String handInString = "";
        if(playerHand.length != 0) {
            for (int i = 0; i < playerHand.length - 1; i++) {
                handInString = handInString + playerHand[i].toString() + ",";
            }
            handInString = handInString + playerHand[playerHand.length - 1].toString();
        } else {
            handInString = "No cards";
        }

        return handInString;
    }

    protected void setDiscardPile(Card topCard){
        discardPile = topCard;
    }
    protected Card getDiscardPile(){
        return discardPile;
    }

    protected int playCard(Crazy8Player player, Card playedCard, Card.Suit cardSuit, Card[] riggedPickup2){

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
            if(player.getNumOfCardsInHand() == 0){
                roundEnded = true;
            }
            return 1;
        } else if ((playedCard.cardRank == Card.Rank.Q) && (canPlay)) {
            skipNextTurn = true;
        } else if ((playedCard.cardRank == Card.Rank.A) && (canPlay)) {
            if(fwdTurnOrder){
                fwdTurnOrder = false;
            } else {
                fwdTurnOrder = true;
            }

        } else if ((playedCard.cardRank == Card.Rank.TWO) && (canPlay)) {
            Crazy8Player currentPlayerPlaying = currentPlayer;

            Crazy8Player nextPlayer = getNextPlayer();

            if(canPlay2CardsImmediately(nextPlayer.getPlayerHand(), playedCard)){
                play2Cards = true;
            } else {
                //If the player before played a 2 then that 2 stacks on top and they pick-up another 2
                lastCard2 = lastCard2 + 1;
                for(int i = 0; i < lastCard2; i++) {
                    //Draw 2 cards and give to next player
                    playerDrawCard(riggedPickup2[0]);
                    playerDrawCard(riggedPickup2[1]);
                }
            }
            currentPlayer = currentPlayerPlaying;
            
        } else {
            lastCard2 = 0;
        }


        if(canPlay){
            setDiscardPile(playedCard);
            player.removeCard(playedCard);
            if(player.getNumOfCardsInHand() == 0){
                roundEnded = true;
            }
            return 1;
        } else {
            return 0;
        }
    }

    protected int playerPlays2Cards(Crazy8Player player, Card card1, Card card2, Card.Suit cardSuit, Card[] riggedPickup2){
        //TODO: may need to fix this method to work with special cards like 8, ACE, Queen and TWO
        Card nullCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
        Card[] nullCardsPickUp = {nullCard, nullCard};
        int check = 0;
        if(card1.cardRank == Card.Rank.EIGHT){
            check = playCard(currentPlayer, card1, cardSuit, nullCardsPickUp);
        } else {
            check = playCard(currentPlayer, card1, Card.Suit.NONE, nullCardsPickUp);
        }
        //If the first card was planned successfully play the second card.
        if(check == 1){
            return playCard(currentPlayer, card2, Card.Suit.NONE, nullCardsPickUp);
        } else {
            return 0;
        }
    }

    protected boolean canPlay2CardsImmediately(Card[] playerHand, Card topCard){
        //TODO: Take into account the special cards like 8, ACE, Queen and TWO
        //Checking to see if 2 cards can be played immediately from players hand
        Card[] potentialFirstCards = new  Card[playerHand.length];
        int count = 0;
        //Add the first potential playable card to array
        for(int i =0; i < playerHand.length; i++){
            if((playerHand[i].cardSuit == topCard.cardSuit) || (playerHand[i].cardRank == topCard.cardRank)){
                //Can play this card
                potentialFirstCards[count]= playerHand[i];
                count++;
            }
        }
        //No card can be played so the player has to pick up 2 cards
        if(count == 0){
            return false;
        }

        //Check to see if there is a second card that can be played
        for(int j = 0; j < count; j++){
            for(int i = 0; i < playerHand.length; i++) {
                if ((playerHand[i].cardSuit == potentialFirstCards[j].cardSuit) && (playerHand[i].cardRank == potentialFirstCards[j].cardRank)) {
                    //Skip the case of the same card in hand being played twice

                } else if ((playerHand[i].cardSuit == potentialFirstCards[j].cardSuit) || (playerHand[i].cardRank == potentialFirstCards[j].cardRank)) {
                    //Can play a second card
                    return true;
                }
            }
        }

        return false;
    }

    protected Crazy8Player getNextPlayer(){
        int currentPlayerNum = currentPlayer.getPlayerNum();
        int numOfPlayers = players.length;
        if(play2cardsNextPlayer == false) {
            //Reset the last drawn card and drawn card count for last player
            currentPlayerCardDrawn = 0;
            lastDrawnCard = new Card(Card.Rank.NONE, Card.Suit.NONE);

            //If the current player played a 2 and the next player can play 2 cards
            if(play2Cards){
                play2cardsNextPlayer = true;
                play2Cards = false;
            }

            int nextPlayerNum = 0;
            if (fwdTurnOrder == true) {
                //Skip next players turn
                if (skipNextTurn) {
                    //Adding 1 here since currentPlayerNum is already one greater than array position
                    lastPlayerTurnSkipped = true;
                    lastPlayerNum = currentPlayerNum + 1;
                    nextPlayerNum = currentPlayerNum + 1;
                    if (nextPlayerNum == numOfPlayers) {
                        nextPlayerNum = 0;
                    } else if (nextPlayerNum > numOfPlayers) {
                        nextPlayerNum = 1;
                        lastPlayerNum = 1;
                    }
                    skipNextTurn = false;
                } else {
                    lastPlayerTurnSkipped = false;
                    lastPlayerNum = currentPlayerNum;

                    //not adding anything here since currentPlayerNum is already one greater than array position
                    nextPlayerNum = currentPlayerNum;
                    if (nextPlayerNum >= numOfPlayers) {
                        nextPlayerNum = 0;
                    }
                }
                currentPlayer = players[nextPlayerNum];
                return players[nextPlayerNum];

            } else {
                //Reverse order
                if (skipNextTurn) {
                    lastPlayerTurnSkipped = true;
                    lastPlayerNum = currentPlayerNum - 1;
                    if (lastPlayerNum == 0) {
                        lastPlayerNum = numOfPlayers;
                    }
                    nextPlayerNum = currentPlayerNum - 3;
                    if (nextPlayerNum == -1) {
                        nextPlayerNum = numOfPlayers - 1;
                    } else if (nextPlayerNum == -2) {
                        nextPlayerNum = numOfPlayers - 2;
                    }
                    skipNextTurn = false;
                } else {
                    //Not skipping a turn
                    lastPlayerTurnSkipped = false;
                    lastPlayerNum = currentPlayerNum;
                    //-2 since currentPlayerNum is one number ahead
                    nextPlayerNum = currentPlayerNum - 2;
                    if (nextPlayerNum < 0) {
                        nextPlayerNum = numOfPlayers - 1;
                    }
                }
                currentPlayer = players[nextPlayerNum];
                return players[nextPlayerNum];
            }
        } else{
            //Player has a second turn
            play2cardsNextPlayer = false;
            return currentPlayer;
        }


    }

    protected String endTurn(){
        String endRoundString = "";
        if(roundEnded){
            calculateScores();
            //TODO:Check for a winner
            boolean ifWinner = false;
            for (int i = 0; i < players.length; i++){
                if(players[i].getScore() >= gameEndingScore){
                    ifWinner = true;
                }
            }
            if(ifWinner){
                //Init the lowest score with the first player
                int lowestScore = players[0].getScore();
                Crazy8Player lowestScorePlayer = players[0];
                //Get the player with the lowest score
                for (int i = 0; i < players.length; i++){
                    if(players[i].getScore() < lowestScore){
                        lowestScore = players[i].getScore();
                        lowestScorePlayer = players[i];
                    }
                }
                endRoundString = endRoundString + "The winner is player " + lowestScorePlayer.getPlayerNum() + " with a score of " + lowestScore + "\n";
                gameover = true;
            } else {
                endRoundString = endRoundString + "No Winner yet moving on to the next Round.";
            }

        } else {
            //endRoundString = endRoundString + "Next Player's Turn";
        }
        return endRoundString;
    }

    protected void calculateScores(){
        for(int i = 0; i < players.length; i++){
            if(players[i].getNumOfCardsInHand() != 0){
                int scoreUpdate = 0;
                Card[] playerHand = players[i].getPlayerHand();
                for(int j=0; j < playerHand.length; j++){
                    scoreUpdate = scoreUpdate + calculateScoreHelper(playerHand[j]);
                }
                players[i].addScore(scoreUpdate);
            }
        }

    }

    private int calculateScoreHelper(Card card){
        int cardValue = 0;
        switch (card.cardRank){
            case A -> cardValue = 10;
            case TWO -> cardValue = 2;
            case THREE -> cardValue = 3;
            case FOUR -> cardValue = 4;
            case FIVE -> cardValue = 5;
            case SIX -> cardValue = 6;
            case SEVEN -> cardValue = 7;
            case EIGHT -> cardValue = 8;
            case NINE -> cardValue = 9;
            case TEN -> cardValue = 10;
            case J -> cardValue = 10;
            case Q -> cardValue = 10;
            case K -> cardValue = 10;
        }
        return cardValue;
    }

    protected String printScoreBoard(){
        String scoreBoard = "";
        switch(players.length) {
            case 1:
                scoreBoard = scoreBoard +"|\tPlayer 1\t|\n";
                break;
            case 2:
                scoreBoard = scoreBoard +"|\tPlayer 1\t|\tPlayer 2\t|\n";
                break;
            case 3:
                scoreBoard = scoreBoard +"|\tPlayer 1\t|\tPlayer 2\t|\tPlayer 3\t|\n";
                break;
            case 4:
                scoreBoard = scoreBoard +"|\tPlayer 1\t|\tPlayer 2\t|\tPlayer 3\t|\tPlayer 4\t|\n";
                break;
        }
        //Format and print scores
        scoreBoard = scoreBoard + "|";
        for(int i = 0; i < players.length; i++){
            scoreBoard = scoreBoard + "\t" + players[i].getScore() + "\t\t\t|";
        }

        scoreBoard = scoreBoard + "\n\n";

        return scoreBoard;
    }

    protected String printScoreBoardInLine(){
        String scoreBoard = "SCOREBOARD: ";
        for(int i = 0; i < players.length; i++){
            scoreBoard = scoreBoard +"Player "+ (i+1) + " Score: " + players[i].getScore() + ". \n";
        }
        return scoreBoard;
    }

    protected Card stringToCard(String cardName){
        Card card;
        String regex = "([2-9]|10|[J|Q|K|A])([S|H|D|C])";
        Card nullCard = new Card(Card.Rank.NONE, Card.Suit.NONE);

        if(Pattern.matches(regex, cardName)){
            Card.Rank rank;
            Card.Suit suit;

            String[] cardChar = cardName.split("(?!^)");

            if(cardChar.length == 2){
                rank = Card.stringToRank(cardChar[0]);
                suit = Card.stringToSuit(cardChar[1]);
            } else if (cardChar.length == 2) {
                rank = Card.stringToRank("10");
                suit = Card.stringToSuit(cardChar[2]);
            } else {
                rank = Card.Rank.NONE;
                suit = Card.Suit.NONE;
            }

            if(rank == Card.Rank.NONE || suit == Card.Suit.NONE){
                return nullCard;
            } else {
                card = new Card(rank, suit);
                return card;
            }
        } else {
            return nullCard;
        }

    }

    protected void setPlayerHand(int playerNum, Card[] hand){
        players[playerNum-1].setPlayerHand(hand);

    }

    public void drawCardForDiscardPile(){
        Card nullCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
        Card drawnCard = deck.drawCard(nullCard);
        setDiscardPile(drawnCard);
    }

    public int getCurrentPlayerNum(){
        for(int i = 0; i < players.length; i++){
            if(currentPlayer == players[i]){
                return i+1;
            }
        }
        return -1;
    }

    public Crazy8Player getCurrentPlayer(){
        return currentPlayer;
    }

    public Card.Suit getCardSuit(String stringSuit){
        return Card.stringToSuit(stringSuit);
    }

}
