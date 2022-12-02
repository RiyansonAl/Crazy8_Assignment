package com.example.Assignment3;

public class MainGameThread extends Thread{
    gameHostBackEnd host;

    public MainGameThread(gameHostBackEnd backEndgameHost) {
        host = backEndgameHost;
    }

    @Override
    public void run() {
       //Main Game loop here

        //Start new round
        host.gameHost.newRound();

        //Start game by dealing everyone cards
        host.allPlayersOutput = "All players are drawing cards\n";
        Card nullCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
        Card[] nullCardHand = new Card[]{nullCard, nullCard, nullCard};
        //loop through all the players and draw a hand
        for(int i = 0 ; i < host.gameHost.players.length; i++){
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
        while(count < 20){
            host.allPlayersOutput = "Discard Pile Top Card: " + host.gameHost.getDiscardPile().toString() + " \n ";
            host.allPlayersOutput = host.allPlayersOutput + "It is Player " + host.gameHost.getCurrentPlayerNum() + " Turn";

            //1 sec delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }





    }
}
