public class RunCard{
	public static void main(String args[]){
		// make a card A-Diamonds
		PlayingCard ad = new PlayingCard(1, 1);
		PlayingCard as = new PlayingCard(1, 3);
		PlayingCard threeC = new PlayingCard(3, 2);

		System.out.println(ad);
		System.out.println(as);
		System.out.println(ad.equals(as));
		System.out.println(threeC);

		System.out.println(ad.equals(threeC));

		MyMethods.clearScreen();
		System.out.println(ad);
		System.out.println(as);
		System.out.println(threeC);

		System.out.println(ad.equals(as));
		System.out.println(ad.compareTo(threeC));
		System.out.println(threeC.compareTo(as));

	}
}