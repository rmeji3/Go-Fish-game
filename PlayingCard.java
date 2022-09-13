/*	Program Name:	MyMethods.java
	Programmer:		Rafael Mejia
	Date:			11/23/21
	This class will define a playing card that will later be used in DeckOfCards and later on one of many card games
*/
	public class PlayingCard{
		// Insatnce Data - All things common to all playing cards
		private String cardFace; 	// K, Q, J, 10 - 2, A with the suit
		private int faceValue;		// numeric value of the card
		private char cardSuit;		// Hold the suit of the card
		// an array of char's to hold the four suits
		// (003) hearts, (004) diamonds, (005) clubs, (006) spades
		private char suits[] = {(char)(003), (char)(004), (char)(005), (char)(006)};

		// Constructor
		public PlayingCard(int value, int suit){
			faceValue = value;
			setFace(); // figure out the face value of the card
			setSuit(suit);  // fiugre out the suit from the array
		}

		// Second Constructor - receives a Playing card - for a players hand
		public PlayingCard(PlayingCard incomingCard){
			this(incomingCard.faceValue, incomingCard.cardSuit);
		}

		// Helper Methods
		// setFace
		public void setFace(){
			switch(faceValue){
				case 1:
					cardFace = "A";
					faceValue = 14;
					break;
				case 11:
					cardFace = "J";
					break;
				case 12:
					cardFace = "Q";
					break;
				case 0:
					cardFace = "K";
					faceValue = 13;
					break;
				default:
					cardFace = ("" + faceValue);
			}
		}// end of setFace

		// set suit
		public void setSuit(int suit){
			cardSuit = suits[suit];
		}

		public int getSuit(){
			return cardSuit;
		}

		// return face value
		public int getFaceValue(){
			return faceValue;
		}
		//comparisons
		//equals()-> compare if the cards have the same value(not worrying about the suit)
		public boolean equals(PlayingCard incomingCard){
			return faceValue == incomingCard.faceValue;
		}
		//compareTo() -> rank the higher card
		public int compareTo(PlayingCard incomingCard){
			if(equals(incomingCard)){
				return 0;
			}else if(faceValue < incomingCard.faceValue){
				return -1;

			}else{
				return 1;
			}
		}
		// to String for printing purposes
		public String toString(){
			return (cardFace + cardSuit);
		}
	}




