package com.example.Assignment3;

public class CardDeck {

    Card[] cards = new Card[52];

    public CardDeck (){
        //Create deck of 52 cards
        int i = 0;
        for(Card.Suit s : Card.Suit.values()){
            for(Card.Rank r : Card.Rank.values()){
                cards[i] = new Card(r, s);
                i++;
            }
        }
    }

    public Card drawCard(Card riggedCard){
        if(riggedCard.cardRank == Card.Rank.NONE){
            int randnum = (int) (Math.random() * (52 - 0)) + 0;
            //IF the card from the deck was already choosen
            while(cards[randnum].cardRank == Card.Rank.NONE){
                randnum++;
                if(randnum > 51){
                    randnum = 0;
                }
            }
            Card drawnCard = cards[randnum];
            cards[randnum].cardRank = Card.Rank.NONE;
            cards[randnum].cardSuit = Card.Suit.NONE;
            return drawnCard;
        } else{
            return riggedCard;
        }


    }





}


