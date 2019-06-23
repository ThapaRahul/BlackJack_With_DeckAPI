
public class StartingCards {
	private Card p1;
	private Card p2;
	private Card d1;
	private Card d2;
	StartingCards(Deck d){
		this.p1 = d.nextCard();
		this.d1 = d.nextCard();
		this.p2 = d.nextCard();
		this.d2 = d.nextCard();
	}
	
	Card getD1(){
		return d1;	
	}
	Card getD2(){
		return d2;	
	}
	Card getP1(){
		return p1;	
	}
	Card getP2(){
		return p2;	
	}
}
