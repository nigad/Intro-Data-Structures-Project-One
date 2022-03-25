
public class Tableau {
	Pile[] tableau;
	Deck deck;
	private static final int num_piles = 13;
	
	public Tableau() {
		tableau = new Pile[num_piles];
		deck = new Deck();
		
		deck.shuffle();
		int cardsInPiles = 52/num_piles;
		for (int i = 0; i < num_piles; i++) {
			tableau[i] = new Pile();
			for (int j = 0; j < cardsInPiles; j++) {
				tableau[i].add(deck.deal());
			}
		}
	}
	
	public void play() {
		int p = 0;
		Card c1 = tableau[p].draw();
		System.out.println("Got " + c1.toString() + " from pile " + p);
		Card c2;
		
		while(!tableau[p].isEmpty()) {
			c2 = tableau[p].draw();
			System.out.println("Got " + c2.toString() + " from pile " + p);
			
			if(c1.getSuit() == c2.getSuit()) {
				p = c1.getRank();
			} else {
				p = c2.getRank();
			}
			
			c1 = c2;
		}
		
		p = 0;
		while(tableau[p].isEmpty()) {
			p++;
		}
		
		if (p == num_piles) {
			System.out.println("We won!");
		} else {
			System.out.println("Pile " + p + " is empty. We lost!");
		}
	}
}
