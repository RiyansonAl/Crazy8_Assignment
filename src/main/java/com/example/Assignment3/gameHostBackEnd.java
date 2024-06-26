package com.example.Assignment3;

public class gameHostBackEnd {

    boolean allPlayersConnected;

    int numOfPlayers;
    int numOfPlayersRemaining;
    int numOfJoinedPlayers;
    Crazy8Player player1;
    Crazy8Player player2;
    Crazy8Player player3;
    Crazy8Player player4;

    Crazy8Player[] players;

    String allPlayersOutput;
    String player1Input;
    String player2Input;
    String player3Input;
    String player4Input;

    Crazy8GameHost gameHost;
    MainGameThread mainThread;

    public gameHostBackEnd(int numPlayers){
        allPlayersConnected = false;
        numOfPlayers = numPlayers;
        numOfPlayersRemaining  = numPlayers - 1;
        player1Input = player2Input = player3Input = player4Input = "";
        allPlayersOutput = "";
        //add player 1 (host)
        player1 = new Crazy8Player(1);
        numOfJoinedPlayers = 1;
        //TODO: Create a thread and call waitingForPlayers method
        waitingForPlayersThread waitingPlayers = new waitingForPlayersThread(this);
        mainThread = new MainGameThread(this);
        waitingPlayers.start();
        System.out.println("Thread started");
        allPlayersOutput = "Back End Thread Created and started";
    }

    public int getNumOfPlayers(){
        return numOfPlayers;
    }

    public int getNumOfPlayersRemaining(){
        return numOfPlayersRemaining;
    }

    public void setNumOfPlayers(int num){
        numOfPlayers = num;
    }

    //TODO: Have a cound to keep track of the players and add them below
    public int joinGame(){
        //Check the number of remaining players and add player to game
        if(numOfPlayersRemaining > 0) {
            switch (numOfJoinedPlayers) {
                case 1:
                    player2 = new Crazy8Player(2);
                    break;
                case 2:
                    player3 = new Crazy8Player(3);
                    break;
                case 3:
                    player4 = new Crazy8Player(4);
                    break;
                default:
                    return 0;
            }
            numOfJoinedPlayers++;
            numOfPlayersRemaining--;
            //Return the player number
            return numOfJoinedPlayers;
        }else{
            return 0;
        }

    }

    //TODO: Delete the method below waitingForPlayer class replaces the method below
    //Loops until all the players join the game
    public void waitingForPlayers(){
        int numplayersWaiting = numOfPlayersRemaining;
        allPlayersOutput = "Waiting on " + numplayersWaiting + " to join the game\n";

        while(numOfPlayersRemaining > 0){

            if(numOfPlayersRemaining <= numplayersWaiting){
                numplayersWaiting = numOfPlayersRemaining;
                allPlayersOutput = "Waiting on " + numplayersWaiting + " to join the game\n";
            }

        }
        //exits the loop when all the players enter the game
        allPlayersOutput = "All players have Join. Host press the Start game button\n";

        //Setup Crazy8GameHost
        players = new Crazy8Player[]{player1, player2, player3, player4};
        gameHost = new Crazy8GameHost(players);

    }

    public String getAllPlayersOutput(){
        return allPlayersOutput;
    }

    public void setPlayerOutput(int playerNum, String input){
        switch(playerNum){
            case 1:
                player1Input = input;
                break;
            case 2:
                player2Input = input;
                break;
            case 3:
                player3Input = input;
                break;
            case 4:
                player4Input = input;
                break;
        }
    }


    public int riggDiscardPile(String stringCard){

        Card card = gameHost.stringToCard(stringCard);
        if(card.cardRank == Card.Rank.NONE || card.cardSuit == Card.Suit.NONE){
            //Return 0 if it fails
            return 0;
        } else {
            gameHost.setDiscardPile(card);
            return 1;
        }
    }

    public int riggPlayerHand(int playerNum, String stringCards){

        String[] playerHandString = stringCards.split(",");
        Card[] playerHand = new Card[playerHandString.length];

        for(int i = 0; i < playerHandString.length; i++){
            playerHand[i] = gameHost.stringToCard(playerHandString[i]);
            if(playerHand[i].cardRank == Card.Rank.NONE || playerHand[i].cardSuit == Card.Suit.NONE){
                return 0;
            }
        }
        gameHost.setPlayerHand(playerNum, playerHand);
        return 1;

    }

    public String getPlayerHand(int playerNum){
        return gameHost.getPlayerHand(playerNum);
    }


    public String playerInputReady(int playerNum){
        String playerInput = "";
        switch(playerNum){
            case 1:
                playerInput = player1Input;
                break;
            case 2:
                playerInput = player2Input;
                break;
            case 3:
                playerInput = player3Input;
                break;
            case 4:
                playerInput = player4Input;
                break;
        }

        if(playerInput != ""){
            return playerInput;
        } else {
            return "";
        }
    }

    public void playerDrawCard(int playerNum){
        Card nullCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
        gameHost.playerChoosesToDrawCard(nullCard);

    }

    public String getTurnOrderDirection(){

        String turnOrder = "";
        if(gameHost.fwdTurnOrder){
            turnOrder = "left";
        } else {
            turnOrder = "right";
        }
        return turnOrder;

    }

    public int setLastDrawnCard(String card){

        Card drawnCard = gameHost.stringToCard(card);

        if(drawnCard.cardRank == Card.Rank.NONE || drawnCard.cardSuit == Card.Suit.NONE){
            return 0;
        } else {
            gameHost.lastDrawnCard = drawnCard;
        }

        return 1;
    }



}
