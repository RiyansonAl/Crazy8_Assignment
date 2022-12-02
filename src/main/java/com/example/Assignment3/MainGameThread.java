package com.example.Assignment3;

public class MainGameThread extends Thread{
    gameHostBackEnd host;

    public MainGameThread(gameHostBackEnd backEndgameHost) {
        host = backEndgameHost;
    }

    @Override
    public void run() {
       //Main Game loop here

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

        host.allPlayersOutput = "All players have finished drawing cards\n";



    }
}
