import java.util.Map;
import java.util.HashMap;

public class Interface {
        private Deck Deck;
    
        public Interface(Deck Deck) {
            this.Deck = Deck;
        }
    
        public void mostrarMenu(Map<String, String> CardsSistema) {
            int option = 0;
    
            while (option != 7) {
                System.out.println("\n1. Agrega una carta");
                System.out.println("\n2. Mostrar el tipo de una Card específica");
                System.out.println("\n3. Mostrar todas las cartas");
                System.out.println("\n4. Mostrar todas las cartas de la colección ordenadas por tipo");
                System.out.println("\n5. Mostrar todas las Ccartas creadas");
                System.out.println("\n6. Mostrar todas las cartas ordenadas por tipo");
                System.out.println("\n7. Salir");
    
                try {
                    option = Functions.readDigit();
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
    
                switch (option) {
                    case 1:
                        addCard(CardsSistema);
                        break;
                    case 2:
                        showTypeCard(CardsSistema);
                        break;
                    case 3:
                        Deck.showAllCards();
                        break;
                    case 4:
                        Deck.showCards();
                        break;
                    case 5:
                        showAllCardsAvailable(CardsSistema);
                        break;
                    case 6:
                        showAllCardsAvailableInOrder(CardsSistema);
                        break;
                    case 7:
                        System.out.println("\nPrograma terminado");
                        // break;
                        return;// ver si cambiar por break
                    default:
                        System.out.println("\nerror, opción no valida\n");
                }
            }
        }
    
        private void addCard(Map<String, String> CardsSistema) {
            System.out.print("\nnombre de la carta");
            String nombreCard = Functions.readEntry();
            System.out.println("\ntipo de la Carta");
            String tipoCard = Functions.readEntry();
    
            if (CardsSistema.containsKey(nombreCard)) {
                Card Card = new Card(nombreCard, tipoCard, 1);
                Deck.addCard(Card);
                System.out.println("\n\ncarta agregada");
            } else {
                System.out.println("\nLa carta " + nombreCard + " no se esta en el sistema.");
            }
        }
    
        private void showTypeCard(Map<String, String> CardsSistema) {
            System.out.print("\nIngrese el nombre de la carta: ");
            String nombreCard = Functions.readEntry();
           
            if (CardsSistema.containsKey(nombreCard)) {
                System.out.println("\nLa carta '" + nombreCard + "' es de tipo: " + CardsSistema.get(nombreCard));
            } else {
                System.out.println("\nLa carta '" + nombreCard + "' no se pudo encuentrar");
            }
        }
    
        private void showAllCardsAvailable(Map<String, String> CardsSistema) {
            for (Map.Entry<String, String> entry : CardsSistema.entrySet()) {
                System.out.println("\nNombre: " + entry.getKey() + " Tipo: " + entry.getValue());
            }
        }
    
        private void showAllCardsAvailableInOrder(Map<String, String> CardsSistema) {
            // ...

            Map<String, Integer> CardsPorTipo = new HashMap<>();
            for (Map.Entry<String, String> entry : CardsSistema.entrySet()) {;
                CardsPorTipo.put(entry.getValue(), CardsPorTipo.getOrDefault(entry.getValue(), 0) + 1);
            }
            for (Map.Entry<String, Integer> entry : CardsPorTipo.entrySet()) {
                String tipoCard = entry.getKey();
                
                System.out.println("Tipo: " + tipoCard);
                System.out.println("Cantidad: " + entry.getValue());
                
                System.out.println("Nombres de las cartas:");
                for (Map.Entry<String, String> Card : CardsSistema.entrySet()) {
                    if (Card.getValue().equals(tipoCard)) {
                        System.out.println("- " + Card.getKey());
                    }
                }
                System.out.println(); 
            }
        }
    
    }
    
