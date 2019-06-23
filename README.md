# BlackJack_With_DeckAPI
This is my personal project utilizing the concept I learned in CSC 1052, Algorithm and Data Structures II. The rules of this game is a little simpler than the actual BlackJack game. The rules are given below:

1. The goal of the game is to get the sum of cards in your hand higher than the dealer’s without
going over 21. Each card is worth the rank value, where face cards are worth 10 and aces are
worth either 1 or 11.
2. The game begins by shuffling and dealing two cards to you and two cards to the dealer. The
program should reveal both cards in your hand but only the first card of the dealer’s hand (the
other card, called the “hole” card, remains hidden).
3. After the initial cards are dealt, you will repeatedly ask the player if they would like to “hit” or
“stay”. If the player hits, the program deals them another card and repeats the query. If the
player stays, this phase of the game ends. If, when the player asks to hit, the sum value of the
cards in their hand exceeds 21, the game immediately ends and the player loses.
4. Once the player stays and has a hand of 21 or less, the dealer plays their hand. The rules for
the dealer are that they must “hit” until the sum value in their hand is greater than or equal to
17.5. If the player’s hand is greater than the dealer’s OR if the dealer goes over 21, the player wins.
If the dealer’s hand is greater than the player’s the dealer wins. If both hands are equal, the
game is a tie.

I have utilized the data structure Arraylist along with Json object and Deck of card API. The link to the api is https://deckofcardsapi.com/
