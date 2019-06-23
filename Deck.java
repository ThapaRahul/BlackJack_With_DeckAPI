import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.html.ImageView;
import org.json.JSONException;

public class Deck {
	
	private HashMap<String, Object> content;
	private String urlNewDeck = "http://deckofcardsapi.com/api/deck/new/";
	
	public Deck() {
		try {
			this.content = URLParseToMap.jsonToMap(urlNewDeck);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void shuffle() {
		try {
			this.content = URLParseToMap.jsonToMap("http://deckofcardsapi.com/api/deck/" + getDeckId() + "/shuffle/");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		//System.out.println(content);
	}
	
	public boolean hasNextCard() {
		String rem = (String) content.get("remaining");
		if (rem.equalsIgnoreCase("0")) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String getDeckId() {
		return (String) this.content.get("deck_id");
	}
	
	public int remainingCard() {
		return (int) this.content.get("remaining");
	}
	
	public Card nextCard() {
		
		HashMap<String, Card.Rank> mapRank = new HashMap<String, Card.Rank>() {{
			put("ACE", Card.Rank.Ace);
			put("2", Card.Rank.Two);
			put("3", Card.Rank.Three);
			put("4", Card.Rank.Four);
			put("5", Card.Rank.Five);
			put("6", Card.Rank.Six);
			put("7", Card.Rank.Seven);
			put("8", Card.Rank.Eight);
			put("9", Card.Rank.Nine);
			put("10", Card.Rank.Ten);
			put("JACK", Card.Rank.Jack);
			put("QUEEN", Card.Rank.Queen);
			put("KING", Card.Rank.King);
		}};
	
		HashMap<String, Card.Suit> mapSuit = new HashMap<String, Card.Suit>() {{
			put("CLUBS", Card.Suit.Club);
			put("DIAMONDS", Card.Suit.Diamond);
			put("SPADES", Card.Suit.Spade);
			put("HEARTS", Card.Suit.Heart);
		}};
		
		HashMap<String, Object> totalDeckMap = null;
		try {
			totalDeckMap = URLParseToMap.jsonToMap("http://deckofcardsapi.com/api/deck/"+ getDeckId() +"/draw/?count=1");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = totalDeckMap.get("cards").toString();
		s = s.substring(1, s.length()-1);
		
		HashMap<String, Object> newCardMap = null;
		try {
			newCardMap = URLParseToMap.jsonstringToMap(s);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Card.Rank rank = mapRank.get(newCardMap.get("value"));
		Card.Suit suit = mapSuit.get(newCardMap.get("suit"));
		String imageUrl = newCardMap.get("image").toString();	
		
		this.content = totalDeckMap;
		String[] imageUrlList = imageUrl.split(":");
		String s1 = imageUrlList[0].substring(0, imageUrlList[0].length()-1);
		String imageUrl1 = s1 + ":" + imageUrlList[1];
		
		return new Card(rank, suit, imageUrl1);
	}
	
	public String toString() {
		return this.content.toString(); 
	}

}
