package sample;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    // instance
    private ArrayList<Card> cards;

    // construct
    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    public int deckSize(){
        return this.cards.size();
    }

    //reset deck values
    public void clearDeck(){
        this.cards.clear();
    }

    public void createDeck(){
        for(Suit cardSuit : Suit.values()){
            for(Value cardValue : Value.values()){
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }

    public void draw(Deck draw){

        this.cards.add((draw.getCard(0)));
        draw.removeCard(0);

    }

    public void shuffle(){
        Collections.shuffle(cards);
    }


    public void removeCard(int i){
        this.cards.remove(i);
    }

    public Card getCard(int i){

        return this.cards.get(i);
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public int cardsValue(){
        int totalvalue = 0;
        int aces = 0;

        for(Card card : this.cards){
            switch(card.getValue()){
                case TWO:
                    totalvalue += 2;
                    break;
                case THREE:
                    totalvalue += 3;
                    break;
                case FOUR:
                    totalvalue += 4;
                    break;
                case FIVE:
                    totalvalue += 5;
                    break;
                case SIX:
                    totalvalue += 6;
                    break;
                case SEVEN:
                    totalvalue += 7;
                    break;
                case EIGHT:
                    totalvalue += 8;
                    break;
                case NINE:
                    totalvalue += 9;
                    break;
                case TEN:
                    totalvalue += 10;
                    break;
                case JACK:
                    totalvalue += 10;
                    break;
                case ACE:
                    // ace?
                    if(totalvalue < 10) {
                        totalvalue += 11;
                    }else{
                        totalvalue += 1;
                    }
                    break;
                case QUEEN:
                    totalvalue += 10;
                    break;
                case KING:
                    totalvalue += 10;
                    break;

            }
        }

        return totalvalue;
    }
    // to check cards
    public String toString(){
        String output = "";
        for(Card card : this.cards){
            output += "\n" + " " + card.toString();
        }
        return output;
    }

}
