/*	Program Name:	GoFish.java
	Programmer: 	Rafael Mejia
	Date:			12/2/21

	This is a modified "go fish" game */

	public class GoFish{
	  	public static void main(String args[]){
	  		// Create the deck to play with
	  		DeckOfCards fishDeck = new DeckOfCards(true);
	  		DeckOfCards player1, p1Pairs, computer, compPairs;

	  		// Instantiate all the "other" decks
	  		player1 = new DeckOfCards();
	  		p1Pairs = new DeckOfCards();
	  		computer = new DeckOfCards();
	  		compPairs = new DeckOfCards();

	  		// shuffle the deck
	  		for(int i = 0; i < 7; i++){
	  			fishDeck.shuffleDeck();
	  		}

	  		// print the deck to make sure everythimg is working properly
	  		//fishDeck.printDeck();

	  		//deal the cards
	  		for(int i = 0; i < 7; i++){
	  			player1.add((PlayingCard)fishDeck.getTopCard());
	  			computer.add((PlayingCard)fishDeck.getTopCard());
	  		}

	  		// give player 1 the first card
	  		//System.out.println("Player 1:");
	  		//player1.printDeck();

	  		checkForPairs(player1, p1Pairs);
	  		System.out.println("Player 1:");
	  		player1.printDeck();
	  		System.out.println("Player 1 PAIRS:");
	  		p1Pairs.printDeck();

	  		// give player 2 the first card
			//System.out.println("Computer:");
	  		//computer.printDeck();
	  		checkForPairs(computer, compPairs);
	  		//System.out.println("Computer Pairs:");
	  		//compPairs.printDeck();

	  		// GAME PLAY
	  		// Playerone goes first
	  		String fishingCard = MyMethods.getString("Which card would you like to fish for? ");
	  		int cardVal;
	  		// translate the users input for comparisons
	  		if(fishingCard.equalsIgnoreCase("A")){
				cardVal = 14;
			}else if(fishingCard.equalsIgnoreCase("K")){
				cardVal = 13;
			}else if(fishingCard.equalsIgnoreCase("Q")){
				cardVal = 12;
			}else if(fishingCard.equalsIgnoreCase("J")){
				cardVal = 11;
			}else{
				// use the integer class to change a string to an int
				cardVal = new Integer(fishingCard).intValue();

			}

			// check the computers hand for match
			//computer.printDeck();
			boolean fishCaught = false;
			for(int i = 0; i < computer.deck.size();i++){
				if(cardVal == ((PlayingCard)computer.deck.get(i)).getFaceValue()){
					player1.add((PlayingCard)computer.deck.get(i));
					computer.deck.remove(i);
					System.out.println("You Caught a Fish!!");
					fishCaught = true;
					i = computer.deck.size(); //kicked out of loop
					//player1.printDeck();
					//computer.printDeck();
				}
			}
			//account for not catching the fish
			if(!fishCaught){
				//add top card off deck to the player
				player1.add((PlayingCard)fishDeck.getTopCard());
				fishCaught = false;
			}
			checkForPairs(player1, p1Pairs);
			//computer's turn
			//randomly generate a card for the user for the computer to ask for
			int compsCardPos = MyMethods.getRandomInt(computer.deck.size());
			PlayingCard compCard = (PlayingCard)computer.deck.get(compsCardPos);
			System.out.println("Computer asks for:\t " + compCard);

			//check player 1 hand for card
			for(int i = 0;i < player1.deck.size(); i++){
				if(compCard.getFaceValue() == ((PlayingCard)player1.deck.get(i).getFaceValue())){
					computer.add((PlayingCard)player1.deck.get(i));
					player1.deck.remove(1);
					caughtFish = true;
					System.out.println("Caught a Fish!!");
					i = player1.deck.size();
				}
			}
			if(!caughtFish){
				computer.add((PlayingCard)fishDeck.getTopCard());
				caughtFish = false;
			}
			checkForPairs(computer, compPairs);
	  	}

	  	private static void checkForPairs(DeckOfCards incomingDeck, DeckOfCards incomingPairDeck){
	  		// nested for loop to iterate through the deck
	  		for(int i = 0; i < incomingDeck.deck.size(); i++){
	  			PlayingCard temp1 = (PlayingCard)incomingDeck.deck.get(i);
	  			// nested loop
	  			for(int j = i + 1; j < incomingDeck.deck.size(); j++){
	  				PlayingCard temp2 = (PlayingCard)incomingDeck.deck.get(j);
	  				if(temp1.equals(temp2)){
	  					// testing to see if the loops are properly working
	  					//System.out.println(temp1 + ", " + temp2 + " - YES");
	  					// add the pairs to my PAIR deck
	  					incomingPairDeck.deck.add(temp1);
	  					incomingPairDeck.deck.add(temp2);
	  					// remove the pair from the players hand
	  					incomingDeck.deck.remove(j);
	  					incomingDeck.deck.remove(i);
	  					i--;
	  					break; // kills the inner loop

	  				}
	  			}
	  		}
	  	}
	  }
