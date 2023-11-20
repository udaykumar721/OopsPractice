import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public static void main(String[] args) {
        List<String> deck = initializeDeck();
        shuffleDeck(deck);
        int numPlayers = 4;
        int cardsPerPlayer = 13;
        String[][] playersCards = new String[numPlayers][cardsPerPlayer];
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                playersCards[i][j] = deck.remove(0);
            }
        }
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Player " + (i + 1) + " cards: " + Arrays.toString(playersCards[i]));
        }
    }
    private static List<String> initializeDeck() {
        List<String> deck = new ArrayList<>();
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck.add(rank + " of " + suit);
            }
        }
        return deck;
    }
    private static void shuffleDeck(List<String> deck) {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }
}
