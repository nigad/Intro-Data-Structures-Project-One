
public class Pile {
	
	private class Layer {
		Card card;
		Layer next;
		
		private Layer(Card card, Layer next) {
			this.card = card;
			this.next = next;
		}
	}
	
	private Layer top;
	
	public Pile() {
		top = null;
	}
	
	public void add(Card card) {
		top = new Layer(card, top);
	}
	
	public Card draw() {
		if (isEmpty()) {
			throw new IllegalStateException("Pile is empty");
		} else {
			Card temp = top.card;
			top = top.next;
			return temp;
		}
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}
