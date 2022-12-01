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

    public static Rank stringToRank(String stringRank){
        switch (stringRank){
            case "2":
                return Rank.TWO;
            case "3":
                return Rank.THREE;
            case "4":
                return Rank.FOUR;
            case "5":
                return Rank.FIVE;
            case "6":
                return Rank.SIX;
            case "7":
                return Rank.SEVEN;
            case "8":
                return Rank.EIGHT;
            case "9":
                return Rank.NINE;
            case "10":
                return Rank.TEN;
            case "J":
                return Rank.J;
            case "Q":
                return Rank.Q;
            case "K":
                return Rank.K;
            case "A":
                return Rank.A;
            default:
                return Rank.NONE;
        }
    }

    public static Suit stringToSuit(String stringSuit) {
        switch (stringSuit) {
            case "S":
                return Suit.S;
            case "H":
                return Suit.H;
            case "C":
                return Suit.C;
            case "D":
                return Suit.D;
            default:
                return Suit.NONE;

        }
    }


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
