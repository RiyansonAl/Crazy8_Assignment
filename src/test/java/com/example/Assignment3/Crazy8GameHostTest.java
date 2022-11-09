package com.example.Assignment3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Crazy8GameHostTest {

    @Test
    @DisplayName("Draw a card")
    void drawcard() {
        Crazy8Player player1 = new Crazy8Player();
        Crazy8Player player2 = new Crazy8Player();
        Crazy8Player player3 = new Crazy8Player();
        Crazy8Player player4 = new Crazy8Player();

        Crazy8Player[] players = {player1, player2, player3, player4};

        Crazy8GameHost host = new Crazy8GameHost(players);
        String rigged = "8H";
        Card riggedCard = new Card(Card.Rank.EIGHT, Card.Suit.H);
        //host.drawcard(rigged);
        assertEquals(rigged,host.drawcard(riggedCard));
    }
}