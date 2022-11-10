package com.example.Assignment3;

public class CardDeck {

    private Card[] cards = new Card[52];
    private int cardsDrawn = 0;

    public CardDeck (){
        //Create deck of 52 cards
        int i = 0;
        Card.Suit[] suits = {Card.Suit.S, Card.Suit.H, Card.Suit.C, Card.Suit.D};
        Card.Rank[] ranks = {Card.Rank.A, Card.Rank.TWO, Card.Rank.THREE, Card.Rank.FOUR, Card.Rank.FIVE, Card.Rank.SIX, Card.Rank.SEVEN, Card.Rank.EIGHT, Card.Rank.NINE, Card.Rank.TEN, Card.Rank.J, Card.Rank.Q, Card.Rank.K};
        for(Card.Suit s : suits){
            for(Card.Rank r : ranks){
                cards[i] = new Card(r, s);
                i++;
            }
        }
    }

    public Card drawCard(Card riggedCard){
        if(riggedCard.cardRank == Card.Rank.NONE){
            int randnum = (int) (Math.random() * (52 - 0)) + 0;
            //IF the card from the deck was already chosen
            while((cards[randnum].cardRank == Card.Rank.NONE) && (cardsDrawn < 52)){
                randnum++;
                if(randnum > 51){
                    randnum = 0;
                }
            }
            if(cardsDrawn >= 52){
                Card nullCard = new Card(Card.Rank.NONE, Card.Suit.NONE);
                return nullCard;
            }
            Card drawnCard =  new Card(cards[randnum].cardRank, cards[randnum].cardSuit);
            cardsDrawn++;
            cards[randnum].cardRank = Card.Rank.NONE;
            cards[randnum].cardSuit = Card.Suit.NONE;
            //System.out.println("Cards Drawn = " + cardsDrawn);
            return drawnCard;
        } else{
            return riggedCard;
        }

    }




}


