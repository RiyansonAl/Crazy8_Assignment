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


    @Override
    public String toString() {
        String rankString = "";
        switch (cardRank){
            case A -> rankString = "A";
            case TWO -> rankString = "2";
            case THREE -> rankString = "3";
            case FOUR -> rankString = "4";
            case FIVE -> rankString = "5";
            case SIX -> rankString = "6";
            case SEVEN -> rankString = "7";
            case EIGHT -> rankString = "8";
            case NINE -> rankString = "9";
            case TEN -> rankString = "10";
            case J -> rankString = "J";
            case Q -> rankString = "Q";
            case K -> rankString = "K";
            default -> rankString = "" + cardRank + "";



        }
        return "" + rankString + cardSuit + "";
    }
}
