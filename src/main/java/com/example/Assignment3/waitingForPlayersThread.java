package com.example.Assignment3;

public class waitingForPlayersThread extends Thread {

    gameHostBackEnd host;

    public waitingForPlayersThread(gameHostBackEnd backEndgameHost){
        host = backEndgameHost;
    }

    public void run(){
        //Waiting for players to join loop
        int numplayersWaiting = host.numOfPlayersRemaining;
        host.allPlayersOutput = "Waiting on " + numplayersWaiting + " to join the game\n";
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //TODO: Remove Count only used for debugginh
        int count = 0;
        //while(host.numOfPlayersRemaining > 0){
        while (count < 10){

            if(host.numOfPlayersRemaining <= numplayersWaiting){
                numplayersWaiting = host.numOfPlayersRemaining;
                host.allPlayersOutput = "Waiting on " + numplayersWaiting + " to join the game\n";
            }

            //loop every second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
        }
        //exits the loop when all the players enter the game
        host.allPlayersOutput = "All players have Join. Host press the Start game button\n";

        //Setup Crazy8GameHost
        host.players = new Crazy8Player[]{host.player1, host.player2, host.player3, host.player4};
        host.gameHost = new Crazy8GameHost(host.players);

    }

}
