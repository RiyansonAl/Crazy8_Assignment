package com.example.Assignment3;

public class Card {

    public enum Suit {
        S,
        H,
        C,
        D,
        NONE
    }

    public enum Rank {
        A,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        J,
        Q,
        K,
        NONE
    }

    Rank cardRank;
    Suit cardSuit;

    public Card(Rank cardrank, Suit cardsuit){
        cardRank = cardrank;
        cardSuit = cardsuit;
    }

    //TODO TOString for returning "8H"
}
