package com.example.Assignment3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Crazy8GameHostTest {

    @Test
    @DisplayName("Draw a card")
    void drawcard() {
        Crazy8Player player1 = new Crazy8Player(1);
        Crazy8Player player2 = new Crazy8Player(2);
        Crazy8Player player3 = new Crazy8Player(3);
        Crazy8Player player4 = new Crazy8Player(4);

        Crazy8Player[] players = {player1, player2, player3, player4};

        Crazy8GameHost host = new Crazy8GameHost(players);
        String rigged = "8H";
        Card riggedCard = new Card(Card.Rank.EIGHT, Card.Suit.H);
        Card nullCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
        //host.drawcard(rigged);
        System.out.println(host.drawCard(nullCard));
        System.out.println(host.drawCard(riggedCard));
        System.out.println(host.drawCard(nullCard));
        assertEquals(riggedCard,host.drawCard(riggedCard));
    }

    @Test
    @DisplayName("Draw a full hand of cards for each player")
    void drawFullHand() {
        Crazy8Player player1 = new Crazy8Player(1);
        Crazy8Player player2 = new Crazy8Player(2);
        Crazy8Player player3 = new Crazy8Player(3);
        Crazy8Player player4 = new Crazy8Player(4);

        Crazy8Player[] players = {player1, player2, player3, player4};

        Crazy8GameHost host = new Crazy8GameHost(players);
        String rigged = "8H";
        //Five cards to draw
        Card riggedCard1 = new Card(Card.Rank.EIGHT, Card.Suit.H);
        Card riggedCard2 = new Card(Card.Rank.TEN, Card.Suit.C);
        Card riggedCard3 = new Card(Card.Rank.SEVEN, Card.Suit.H);
        Card riggedCard4 = new Card(Card.Rank.K, Card.Suit.D);
        Card riggedCard5 = new Card(Card.Rank.Q, Card.Suit.S);

        Card[] riggedHand = {riggedCard1, riggedCard2, riggedCard3, riggedCard4, riggedCard5};
        Card[] player1Hand = host.drawHand(player1, riggedHand);
        String player1HandString = "8H,10C,7H,KD,QS";
        assertEquals(player1HandString,host.printHand(player1));
    }

    @Test
    @DisplayName("Player 1 plays a card")
    void playcardnormal() {
        Crazy8Player player1 = new Crazy8Player(1);
        Crazy8Player player2 = new Crazy8Player(2);
        Crazy8Player player3 = new Crazy8Player(3);
        Crazy8Player player4 = new Crazy8Player(4);

        Crazy8Player[] players = {player1, player2, player3, player4};

        Crazy8GameHost host = new Crazy8GameHost(players);
        //Five cards to draw
        Card riggedCard1 = new Card(Card.Rank.EIGHT, Card.Suit.H);
        Card riggedCard2 = new Card(Card.Rank.TEN, Card.Suit.C);
        Card riggedCard3 = new Card(Card.Rank.SEVEN, Card.Suit.H);
        Card riggedCard4 = new Card(Card.Rank.K, Card.Suit.D);
        Card riggedCard5 = new Card(Card.Rank.Q, Card.Suit.S);

        Card[] riggedHand = {riggedCard1, riggedCard2, riggedCard3, riggedCard4, riggedCard5};
        Card[] player1Hand = host.drawHand(player1, riggedHand);
        String player1HandString = "8H,10C,KD,QS";

        Card discardPileTop = new Card(Card.Rank.SIX, Card.Suit.H);

        Card nullCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
        Card[] nullCardsPickUp = {nullCard, nullCard};

        host.setDiscardPile(discardPileTop);
        host.playCard(player1, riggedCard3, Card.Suit.NONE, nullCardsPickUp);

        assertEquals(player1HandString,host.printHand(player1));
    }

    @Test
    @DisplayName("Player 1 plays an 8 and changes the suit to D")
    void playcard8() {
        Crazy8Player player1 = new Crazy8Player(1);
        Crazy8Player player2 = new Crazy8Player(2);
        Crazy8Player player3 = new Crazy8Player(3);
        Crazy8Player player4 = new Crazy8Player(4);

        Crazy8Player[] players = {player1, player2, player3, player4};

        Crazy8GameHost host = new Crazy8GameHost(players);
        //Five cards to draw
        Card riggedCard1 = new Card(Card.Rank.EIGHT, Card.Suit.H);
        Card riggedCard2 = new Card(Card.Rank.TEN, Card.Suit.C);
        Card riggedCard3 = new Card(Card.Rank.SEVEN, Card.Suit.H);
        Card riggedCard4 = new Card(Card.Rank.K, Card.Suit.D);
        Card riggedCard5 = new Card(Card.Rank.Q, Card.Suit.S);

        Card[] riggedHand = {riggedCard1, riggedCard2, riggedCard3, riggedCard4, riggedCard5};
        Card[] player1Hand = host.drawHand(player1, riggedHand);
        String player1HandString = "10C,7H,KD,QS";

        Card discardPileTop = new Card(Card.Rank.SIX, Card.Suit.H);

        Card nullCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
        Card[] nullCardsPickUp = {nullCard, nullCard};

        host.setDiscardPile(discardPileTop);
        host.playCard(player1, riggedCard1, Card.Suit.D, nullCardsPickUp);
        //System.out.println(host.getDiscardPile().toString());

        assertEquals(player1HandString,host.printHand(player1));

    }

    @Test
    @DisplayName("Player 1 plays a card and then the next player plays a card")
    void playcardnormalTurns() {
        Crazy8Player player1 = new Crazy8Player(1);
        Crazy8Player player2 = new Crazy8Player(2);
        Crazy8Player player3 = new Crazy8Player(3);
        Crazy8Player player4 = new Crazy8Player(4);

        Crazy8Player[] players = {player1, player2, player3, player4};

        Crazy8GameHost host = new Crazy8GameHost(players);
        //Five cards to draw - player 1
        Card riggedCard1 = new Card(Card.Rank.EIGHT, Card.Suit.H);
        Card riggedCard2 = new Card(Card.Rank.TEN, Card.Suit.C);
        Card riggedCard3 = new Card(Card.Rank.SEVEN, Card.Suit.H);
        Card riggedCard4 = new Card(Card.Rank.K, Card.Suit.D);
        Card riggedCard5 = new Card(Card.Rank.Q, Card.Suit.S);

        Card[] riggedHand = {riggedCard1, riggedCard2, riggedCard3, riggedCard4, riggedCard5};
        Card[] player1Hand = host.drawHand(player1, riggedHand);
        String player1HandString = "8H,10C,KD,QS";

        //Five cards to draw - player 2
        Card riggedCard6 = new Card(Card.Rank.NINE, Card.Suit.D);
        Card riggedCard7 = new Card(Card.Rank.SEVEN, Card.Suit.D);
        Card riggedCard8 = new Card(Card.Rank.TWO, Card.Suit.C);
        Card riggedCard9 = new Card(Card.Rank.J, Card.Suit.D);
        Card riggedCard10 = new Card(Card.Rank.K, Card.Suit.S);

        Card[] riggedHand2 = {riggedCard6, riggedCard7, riggedCard8, riggedCard9, riggedCard10};
        Card[] player2Hand = host.drawHand(player2, riggedHand2);
        String player2HandString = "9D,2C,JD,KS";

        Card discardPileTop = new Card(Card.Rank.SIX, Card.Suit.H);

        Card nullCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
        Card[] nullCardsPickUp = {nullCard, nullCard};

        host.setDiscardPile(discardPileTop);
        host.playCard(player1, riggedCard3, Card.Suit.NONE, nullCardsPickUp);
        Crazy8Player nextPlayer = host.getNextPlayer();
        host.playCard(nextPlayer, riggedCard7, Card.Suit.NONE, nullCardsPickUp);
        /*
        //Testing the turn order
        host.fwdTurnOrder = true;
        host.skipNextTurn = true;
        System.out.println("Current Player = Player " + host.currentPlayer.getPlayerNum() + "\n");
        nextPlayer = host.getNextPlayer();
        System.out.println("Current Player = Player " + host.currentPlayer.getPlayerNum() + "\n");
        nextPlayer = host.getNextPlayer();
        System.out.println("Current Player = Player " + host.currentPlayer.getPlayerNum() + "\n");
        nextPlayer = host.getNextPlayer();
        System.out.println("Current Player = Player " + host.currentPlayer.getPlayerNum() + "\n");
        host.skipNextTurn = true;
        nextPlayer = host.getNextPlayer();
        System.out.println("Current Player = Player " + host.currentPlayer.getPlayerNum() + "\n");
        nextPlayer = host.getNextPlayer();
        System.out.println("Current Player = Player " + host.currentPlayer.getPlayerNum() + "\n");
        nextPlayer = host.getNextPlayer();
        System.out.println("Current Player = Player " + host.currentPlayer.getPlayerNum() + "\n");
        */

        assertEquals(player1HandString,host.printHand(player1));
        assertEquals(player2HandString,host.printHand(player2));

    }

    @Test
    @DisplayName("Player 1 plays a Queen and skips player 2's turn and it becomes player 3's turn")
    void playcardQueen() {
        Crazy8Player player1 = new Crazy8Player(1);
        Crazy8Player player2 = new Crazy8Player(2);
        Crazy8Player player3 = new Crazy8Player(3);
        Crazy8Player player4 = new Crazy8Player(4);

        Crazy8Player[] players = {player1, player2, player3, player4};

        Crazy8GameHost host = new Crazy8GameHost(players);
        //Five cards to draw - player 1
        Card riggedCard1 = new Card(Card.Rank.EIGHT, Card.Suit.H);
        Card riggedCard2 = new Card(Card.Rank.TEN, Card.Suit.C);
        Card riggedCard3 = new Card(Card.Rank.SEVEN, Card.Suit.H);
        Card riggedCard4 = new Card(Card.Rank.K, Card.Suit.D);
        Card riggedCard5 = new Card(Card.Rank.Q, Card.Suit.S);

        Card[] riggedHand = {riggedCard1, riggedCard2, riggedCard3, riggedCard4, riggedCard5};
        Card[] player1Hand = host.drawHand(player1, riggedHand);
        String player1HandString = "8H,10C,7H,KD";

        //Five cards to draw - player 2
        Card riggedCard6 = new Card(Card.Rank.NINE, Card.Suit.D);
        Card riggedCard7 = new Card(Card.Rank.SEVEN, Card.Suit.D);
        Card riggedCard8 = new Card(Card.Rank.TWO, Card.Suit.C);
        Card riggedCard9 = new Card(Card.Rank.J, Card.Suit.D);
        Card riggedCard10 = new Card(Card.Rank.K, Card.Suit.S);

        Card nullCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
        Card[] nullCardsPickUp = {nullCard, nullCard};

        Card[] riggedHand2 = {riggedCard6, riggedCard7, riggedCard8, riggedCard9, riggedCard10};
        Card[] player3Hand = host.drawHand(player3, riggedHand2);
        String player3HandString = "9D,7D,2C,JD";

        Card discardPileTop = new Card(Card.Rank.SIX, Card.Suit.S);

        host.setDiscardPile(discardPileTop);
        host.playCard(player1, riggedCard5, Card.Suit.NONE, nullCardsPickUp);
        Crazy8Player nextPlayer = host.getNextPlayer();
        host.playCard(nextPlayer, riggedCard10, Card.Suit.NONE, nullCardsPickUp);

        assertEquals(player1HandString,host.printHand(player1));
        assertEquals(player3HandString,host.printHand(player3));
    }

    @Test
    @DisplayName("Player 1 plays a Ace and reverses the order of turns and it becomes player 4's turn")
    void playcardAce() {
        Crazy8Player player1 = new Crazy8Player(1);
        Crazy8Player player2 = new Crazy8Player(2);
        Crazy8Player player3 = new Crazy8Player(3);
        Crazy8Player player4 = new Crazy8Player(4);

        Crazy8Player[] players = {player1, player2, player3, player4};

        Crazy8GameHost host = new Crazy8GameHost(players);
        //Five cards to draw - player 1
        Card riggedCard1 = new Card(Card.Rank.EIGHT, Card.Suit.H);
        Card riggedCard2 = new Card(Card.Rank.TEN, Card.Suit.C);
        Card riggedCard3 = new Card(Card.Rank.SEVEN, Card.Suit.H);
        Card riggedCard4 = new Card(Card.Rank.K, Card.Suit.D);
        Card riggedCard5 = new Card(Card.Rank.A, Card.Suit.S);

        Card[] riggedHand = {riggedCard1, riggedCard2, riggedCard3, riggedCard4, riggedCard5};
        Card[] player1Hand = host.drawHand(player1, riggedHand);
        String player1HandString = "8H,10C,7H,KD";

        //Five cards to draw - player 2
        Card riggedCard6 = new Card(Card.Rank.NINE, Card.Suit.D);
        Card riggedCard7 = new Card(Card.Rank.SEVEN, Card.Suit.D);
        Card riggedCard8 = new Card(Card.Rank.TWO, Card.Suit.C);
        Card riggedCard9 = new Card(Card.Rank.J, Card.Suit.D);
        Card riggedCard10 = new Card(Card.Rank.K, Card.Suit.S);

        Card nullCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
        Card[] nullCardsPickUp = {nullCard, nullCard};

        Card[] riggedHand2 = {riggedCard6, riggedCard7, riggedCard8, riggedCard9, riggedCard10};
        Card[] player4Hand = host.drawHand(player4, riggedHand2);
        String player4HandString = "9D,7D,2C,JD";

        Card discardPileTop = new Card(Card.Rank.SIX, Card.Suit.S);

        host.setDiscardPile(discardPileTop);
        host.playCard(player1, riggedCard5, Card.Suit.NONE, nullCardsPickUp);
        Crazy8Player nextPlayer = host.getNextPlayer();
        host.playCard(nextPlayer, riggedCard10, Card.Suit.NONE, nullCardsPickUp);

        assertEquals(player1HandString,host.printHand(player1));
        assertEquals(player4HandString,host.printHand(player4));
    }

    @Test
    @DisplayName("Player 1 plays a 2 and then the next player picks up 2 cards if they cant play 2 cards immediately")
    void playcarddraw2() {
        Crazy8Player player1 = new Crazy8Player(1);
        Crazy8Player player2 = new Crazy8Player(2);
        Crazy8Player player3 = new Crazy8Player(3);
        Crazy8Player player4 = new Crazy8Player(4);

        Crazy8Player[] players = {player1, player2, player3, player4};

        Crazy8GameHost host = new Crazy8GameHost(players);
        //Five cards to draw - player 1
        Card riggedCard1 = new Card(Card.Rank.EIGHT, Card.Suit.H);
        Card riggedCard2 = new Card(Card.Rank.TEN, Card.Suit.C);
        Card riggedCard3 = new Card(Card.Rank.TWO, Card.Suit.H);
        Card riggedCard4 = new Card(Card.Rank.K, Card.Suit.D);
        Card riggedCard5 = new Card(Card.Rank.Q, Card.Suit.S);

        Card[] riggedHand = {riggedCard1, riggedCard2, riggedCard3, riggedCard4, riggedCard5};
        Card[] player1Hand = host.drawHand(player1, riggedHand);
        String player1HandString = "8H,10C,KD,QS";

        //Five cards to draw - player 2
        Card riggedCard6 = new Card(Card.Rank.NINE, Card.Suit.D);
        Card riggedCard7 = new Card(Card.Rank.SEVEN, Card.Suit.D);
        Card riggedCard8 = new Card(Card.Rank.THREE, Card.Suit.C);
        Card riggedCard9 = new Card(Card.Rank.J, Card.Suit.D);
        Card riggedCard10 = new Card(Card.Rank.K, Card.Suit.S);

        //Two cards that was drawn by next player
        Card riggedCard11 = new Card(Card.Rank.K, Card.Suit.H);
        Card riggedCard12 = new Card(Card.Rank.J, Card.Suit.S);
        Card[] riggedCardsPickUp = {riggedCard11, riggedCard12};
        Card nullCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
        Card[] nullCardsPickUp = {nullCard, nullCard};

        Card[] riggedHand2 = {riggedCard6, riggedCard7, riggedCard8, riggedCard9, riggedCard10};
        Card[] player2Hand = host.drawHand(player2, riggedHand2);
        String player2HandString = "9D,7D,3C,JD,KS,KH,JS";

        Card discardPileTop = new Card(Card.Rank.SIX, Card.Suit.H);

        host.setDiscardPile(discardPileTop);
        host.playCard(player1, riggedCard3, Card.Suit.NONE, riggedCardsPickUp);
        Crazy8Player nextPlayer = host.getNextPlayer();
        host.playCard(nextPlayer, riggedCard7, Card.Suit.NONE, nullCardsPickUp);

        assertEquals(player1HandString,host.printHand(player1));
        assertEquals(player2HandString,host.printHand(player2));
    }

    @Test
    @DisplayName("Player 1 plays a 2 and then the next player immediately plays 2 cards immediately")
    void playcardplay2() {
        Crazy8Player player1 = new Crazy8Player(1);
        Crazy8Player player2 = new Crazy8Player(2);
        Crazy8Player player3 = new Crazy8Player(3);
        Crazy8Player player4 = new Crazy8Player(4);

        Crazy8Player[] players = {player1, player2, player3, player4};

        Crazy8GameHost host = new Crazy8GameHost(players);
        //Five cards to draw - player 1
        Card riggedCard1 = new Card(Card.Rank.EIGHT, Card.Suit.H);
        Card riggedCard2 = new Card(Card.Rank.TEN, Card.Suit.C);
        Card riggedCard3 = new Card(Card.Rank.TWO, Card.Suit.H);
        Card riggedCard4 = new Card(Card.Rank.K, Card.Suit.D);
        Card riggedCard5 = new Card(Card.Rank.Q, Card.Suit.S);

        Card[] riggedHand = {riggedCard1, riggedCard2, riggedCard3, riggedCard4, riggedCard5};
        Card[] player1Hand = host.drawHand(player1, riggedHand);
        String player1HandString = "8H,10C,KD,QS";

        //Five cards to draw - player 2
        Card riggedCard6 = new Card(Card.Rank.NINE, Card.Suit.H);
        Card riggedCard7 = new Card(Card.Rank.SEVEN, Card.Suit.D);
        Card riggedCard8 = new Card(Card.Rank.THREE, Card.Suit.H);
        Card riggedCard9 = new Card(Card.Rank.J, Card.Suit.D);
        Card riggedCard10 = new Card(Card.Rank.K, Card.Suit.S);

        Card nullCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
        Card[] nullCardsPickUp = {nullCard, nullCard};

        Card[] riggedHand2 = {riggedCard6, riggedCard7, riggedCard8, riggedCard9, riggedCard10};
        Card[] player2Hand = host.drawHand(player2, riggedHand2);
        String player2HandString = "7D,JD,KS";

        Card discardPileTop = new Card(Card.Rank.SIX, Card.Suit.H);

        host.setDiscardPile(discardPileTop);
        host.playCard(player1, riggedCard3, Card.Suit.NONE, nullCardsPickUp);
        Crazy8Player nextPlayer = host.getNextPlayer();
        if(host.play2Cards == true){
            host.playerPlays2Cards(nextPlayer, riggedCard6, riggedCard8, Card.Suit.NONE, nullCardsPickUp);
        } else {
            host.playCard(nextPlayer, riggedCard7, Card.Suit.NONE, nullCardsPickUp);
        }

        assertEquals(player1HandString,host.printHand(player1));
        assertEquals(player2HandString,host.printHand(player2));
    }




}