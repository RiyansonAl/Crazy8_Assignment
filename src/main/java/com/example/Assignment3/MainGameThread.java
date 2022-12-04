package com.example.Assignment3;

public class MainGameThread extends Thread{
    gameHostBackEnd host;

    public MainGameThread(gameHostBackEnd backEndgameHost) {
        host = backEndgameHost;
    }

    @Override
    public void run() {
        //Main Game loop here
        while (host.gameHost.gameover == false) {

            //Start new round
            host.gameHost.newRound();

            //Start game by dealing everyone cards
            host.allPlayersOutput = "Starting a new round...... All players are drawing cards\n";
            Card nullCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
            Card[] nullCardHand = new Card[]{nullCard, nullCard, nullCard};
            //loop through all the players and draw a hand
            for (int i = 0; i < host.gameHost.players.length; i++) {
                host.gameHost.drawHand(host.gameHost.players[i], nullCardHand);
            }

            //5 sec delay
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            //Draw card for the discard pile
            host.gameHost.drawCardForDiscardPile();
            //Start the game by putting down and displaying the card in the discard pile

            host.allPlayersOutput = "All players have finished drawing cards\n";
            host.allPlayersOutput = host.allPlayersOutput + "Discard Pile Top Card: " + host.gameHost.getDiscardPile().toString() + "\n";

            //2 sec delay
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int count = 0;
            while (host.gameHost.roundEnded == false) {
                host.allPlayersOutput = "Discard Pile Top Card: " + host.gameHost.getDiscardPile().toString() + " \n ";
                host.allPlayersOutput = host.allPlayersOutput + "It is Player " + host.gameHost.getCurrentPlayerNum() + " Turn";

                //TODO: ignore inputs of all players but the current player
                //If any player but the current player tries to play a card ignore there input and set it to null
                for (int i = 0; i < host.gameHost.players.length; i++) {
                    if ((i + 1) != host.gameHost.getCurrentPlayerNum()) {
                        String otherPlayerInput = host.playerInputReady(i + 1);
                        if (otherPlayerInput != "") {
                            host.setPlayerOutput(i + 1, "");
                        }
                    }
                }

                //Check if current Player is placed a card down
                String currentPlayerInput = host.playerInputReady(host.gameHost.getCurrentPlayerNum());
                if (currentPlayerInput != "") {
                    String[] playerInput = currentPlayerInput.split(",");
                    //Convert play input to card
                    Card playedCard = host.gameHost.stringToCard(playerInput[0]);
                    Crazy8Player currentPlayer = host.gameHost.getCurrentPlayer();
                    Card.Suit suit = host.gameHost.getCardSuit(playerInput[1]);
                    Card[] nullhand = {nullCard, nullCard};

                    //Warning if player input is not correct
                    //If player input is not a valid card
                    //If player plays an 8 and the Suit is NONE
                    if (playedCard.cardRank == Card.Rank.NONE) {
                        //If player input is not a valid card
                        host.allPlayersOutput = "Discard Pile Top Card: " + host.gameHost.getDiscardPile().toString() + " \n ";
                        host.allPlayersOutput = host.allPlayersOutput + "The Card the player put down is not vaild. ";
                        host.allPlayersOutput = host.allPlayersOutput + "It is still Player " + host.gameHost.getCurrentPlayerNum() + " Turn";
                    } else if ((playedCard.cardRank == Card.Rank.EIGHT) && (suit == Card.Suit.NONE)) {
                        //If player plays an 8 and the Suit is NONE
                        host.allPlayersOutput = "Discard Pile Top Card: " + host.gameHost.getDiscardPile().toString() + " \n ";
                        host.allPlayersOutput = host.allPlayersOutput + "Player did not choose a valid suit when playing a 8. ";
                        host.allPlayersOutput = host.allPlayersOutput + "It is still Player " + host.gameHost.getCurrentPlayerNum() + " Turn";
                    } else {
                        int played = host.gameHost.playCard(currentPlayer, playedCard, suit, nullhand);
                        if (played == 0) {
                            host.allPlayersOutput = "Discard Pile Top Card: " + host.gameHost.getDiscardPile().toString() + " \n ";
                            host.allPlayersOutput = host.allPlayersOutput + "The player cannot put this card down choose another card. ";
                            host.allPlayersOutput = host.allPlayersOutput + "It is still Player " + host.gameHost.getCurrentPlayerNum() + " Turn";
                        } else {
                            //Set Player input back to null
                            host.setPlayerOutput(host.gameHost.getCurrentPlayerNum(), "");
                            host.allPlayersOutput = "Discard Pile Top Card: " + host.gameHost.getDiscardPile().toString() + " \n ";
                            host.allPlayersOutput = host.allPlayersOutput + host.gameHost.endTurn();
                            //TODO: Check if this player finished all there cards, if player has no cards then end turn.
                            String playerHand = host.getPlayerHand(host.gameHost.getCurrentPlayerNum());
                            if (playerHand == "No cards") {
                                //host.allPlayersOutput = host.gameHost.endTurn();
                            }

                            //Set the turn Order for the next players
                            host.gameHost.getNextPlayer();
                        }
                    }

                }
                //1 sec delay
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            //TODO: Display score at the end of the round
            //End of the round display score
            if (host.gameHost.roundEnded == true) {
                host.allPlayersOutput = host.allPlayersOutput + host.gameHost.printScoreBoardInLine();
            }
            //5 sec delay
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
