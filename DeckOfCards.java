

import java.util.ArrayList;
import java.util.ListIterator;

public class DeckOfCards{

	//instance data
	ArrayList deck;
	//default constructor -> doesnt do anything
	public DeckOfCards(){
	deck = new ArrayList();

	}

	//second contstructor -> build a full deck of cards
	public DeckOfCards(boolean fullDeck){
		deck = new ArrayList();
		int suit;
		//use a loop to create the 52 cards
		for(int i = 0; i < 52; i++){
			//generate the suit H,D,C,S
			if(i < 13){
				suit = 0; //heart
			}else if (i < 26){
				suit = 1; //diamond

			}else if(i < 39){
				suit = 2; //club

			}else{
				suit = 3; //spade
			}
			deck.add(new PlayingCard((i +1) % 13, suit));
		}
	}
	public void shuffleDeck(){
		//temp deck to hold cards while shuffling called tempDeck
		ArrayList tempDeck = new ArrayList();

		//random card from deck
		int randomCard;

		//use while loop to process the shuffling
		while(deck.size() != 0){ //run while there are cards in the deck
			//pick our random card
			randomCard = MyMethods.getRandomInt(deck.size());
			//add the random card to the temporary deck
			tempDeck.add((PlayingCard)deck.get(randomCard));
			//remove the card from the deck
			deck.remove(randomCard);
		}
		//put shuffled cards back into deck
		//use list iterator to process temp deck
		ListIterator deckIterator = tempDeck.listIterator();

		while(deckIterator.hasNext()){
			deck.add((PlayingCard)deckIterator.next());
		}
	}

	//get top card from deck
	public PlayingCard getTopCard(){
		PlayingCard temp = (PlayingCard)deck.get(0);
		deck.remove(0);
		return temp;
	}

	public void add(PlayingCard incomingCard){
		deck.add((PlayingCard)incomingCard);
	}

	//print deck suing the list iterator
	public void printDeck(){
		//create list iterator
		ListIterator deckIterator = deck.listIterator();

		//use a while loop with list iterator
		int count = 0;
		while(deckIterator.hasNext()){
			if(count != 0 && count % 13 == 0)
			System.out.println();
			System.out.print(deckIterator.next());
			count++;

		}
		System.out.println();
	}
}