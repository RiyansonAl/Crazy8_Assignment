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
        while(host.numOfPlayersRemaining > 0){
        //while (count < 10){

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
        host.allPlayersOutput = "All players have Join. The Game is starting in 10 seconds\n";

        //Setup Crazy8GameHost
        switch (host.getNumOfPlayers()){
            case 2:
                host.players = new Crazy8Player[]{host.player1, host.player2};
                break;
            case 3:
                host.players = new Crazy8Player[]{host.player1, host.player2, host.player3};
                break;
            case 4:
                host.players = new Crazy8Player[]{host.player1, host.player2, host.player3, host.player4};
                break;
            default:
                host.allPlayersOutput = "Not enough players. Please close the web browser and try again with the correct number of players\n";
                while (true){
                    host.allPlayersOutput = "Not enough players. Please close the web browser and try again with the correct number of players\n";
                    //10 sec delay before starting the next thread
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

        }
        host.gameHost = new Crazy8GameHost(host.players);

        //10 sec delay before starting the next thread
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //TODO: Start main game thread here
        host.mainThread.start();



    }

}
