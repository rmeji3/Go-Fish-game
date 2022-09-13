public class RunDeck{
	public static void main (String args[]){
		DeckOfCards myDeck = new DeckOfCards(true);

		//myDeck.printDeck();
		myDeck.shuffleDeck();
		myDeck.printDeck();

		//make 2 players

		DeckOfCards player1 = new DeckOfCards();
		DeckOfCards player2 = new DeckOfCards();

		//deal mutliple cards
		for(int i = 0; i < 7; i++){
			player1.add((PlayingCard)myDeck.getTopCard());
			player2.add((PlayingCard)myDeck.getTopCard());
		}

		//give player1 first card
		player1.add((PlayingCard)myDeck.getTopCard());
		System.out.println("Player1: ");
		player1.printDeck();

		//give player 2 the second card
		player2.add((PlayingCard)myDeck.getTopCard());
		System.out.println("Player2: ");
		player2.printDeck();


}
}