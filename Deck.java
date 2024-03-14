import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Deck extends HashMap<String, Card> {
    private Map<String, Card> Cards;

    public Deck(Map<String, Card> Cards) {
        this.Cards = Cards;
    }
    
    
    /** 
     * @param Card
     */
    public void addCard(Card Card) {
        if (Cards.containsKey(Card.getName())) {
            Card CardExistente = Cards.get(Card.getName());
            CardExistente.setQuantity(CardExistente.getQuantity() + 1);
        } else {
            Cards.put(Card.getName(), Card);
        }
    }
    
    /** 
     * @param nombreCard
     */
    public void deleteCard(String nombreCard) {
        if (Cards.containsKey(nombreCard)) {
            Cards.remove(nombreCard);
        } else {
            System.out.println("La Card " + nombreCard + " no existe la carta sen el Deck.");
        }
    }

    
    /** 
     * @param nombreCard
     * @return Card
     */
    public Card searchCard(String nombreCard) {
        return Cards.get(nombreCard);
    }

    public void showAllCards() {
        int c = 0;
        for (Card Card : Cards.values()) {
            c++;
            System.out.println(Card);
        }
        if(c == 0){
            System.out.println("\nno hay cartas en el Deck\n");
        }
    }

    public void showCards() {
        Map<String, Integer> CardsPorTipo = new TreeMap<>();
        for (Card Card : Cards.values()) {
            CardsPorTipo.put(Card.getType(), CardsPorTipo.getOrDefault(Card.getType(), 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : CardsPorTipo.entrySet()) {
            System.out.println("Tipo es: " + entry.getKey() + " y la Cantidad es: " + entry.getValue());
        }
    }
}
