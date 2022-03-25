import java.util.Random;

public class Deck {
	
	private Card[] cards;
	private int count;
	private static final int cardsInDeck = 52;
	
	public Deck() {
		cards = new Card[cardsInDeck];
		count = 0;
		//This creates each suit, and the inside loop creates each rank card
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 12; j++) {
				cards[count] = new Card(j, i);
				count++;
			}
		}
	}
	
	private boolean isEmpty() {
		return count == 0;
	}
	
	public Card deal() {
		if(isEmpty()) {
			throw new IllegalStateException("No Cards in Deck");
		} else {
			Card temp = cards[count-1];
			cards[count-1] = null;
			count -= 1;
			return temp;
		}
	}
	
	public void shuffle() {
		if (isEmpty()) {
			throw new IllegalStateException("No Cards in Deck");
		} else {
			Random r = new Random();
			for (int i = count-1; i >= 1; i -= 1) {
				int rand = Math.abs(r.nextInt()) % i;
				Card temp = cards[rand];
				cards[rand] = cards[i];
				cards[i] = temp;
			}
		}
	}
}
