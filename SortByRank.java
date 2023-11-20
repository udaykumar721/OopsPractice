import java.util.*;
class Card {
    private String suit;
    private String rank;
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }
    public String getSuit() {
        return suit;
    }
    public String getRank() {
        return rank;
    }
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
class Player {
    private String name;
    private LinkedList<Card> cards;
    public Player(String name) {
        this.name = name;
        this.cards = new LinkedList<>();
    }
    public void receiveCard(Card card) {
        cards.add(card);
    }
    public void sortCardsByRank() {
        cards.sort(Comparator.comparing(Card::getRank));
    }
    public String getName() {
        return name;
    }
    public LinkedList<Card> getCards() {
        return cards;
    }
}
public class SortByRank {
    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    public static void main(String[] args) {
        List<Card> deck = initializeDeck();
        shuffleDeck(deck);
        int numPlayers = 4;
        int cardsPerPlayer = 13;
        Card[][] playersCards = new Card[numPlayers][cardsPerPlayer];
        Queue<Player> playerQueue = new LinkedList<>();
        for (int i = 0; i < numPlayers; i++) {
            Player player = new Player("Player " + (i + 1));
            playerQueue.add(player);

            for (int j = 0; j < cardsPerPlayer; j++) {
                Card card = deck.remove(0);
                playersCards[i][j] = card;
                player.receiveCard(card);
            }
        }
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Player " + (i + 1) + "'s Cards: " + Arrays.toString(playersCards[i]));
        }
        for (Player player : playerQueue) {
            player.sortCardsByRank();
        }
        System.out.println("\nPlayers and Sorted Cards:");
        for (Player player : playerQueue) {
            System.out.println(player.getName() + "'s Sorted Cards: " + player.getCards());
        }
    }
    private static List<Card> initializeDeck() {
        List<Card> deck = new ArrayList<>();
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }
    private static void shuffleDeck(List<Card> deck) {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }
}
