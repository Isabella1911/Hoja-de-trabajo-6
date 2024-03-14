import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;



public class Interface {
    private Deck deck;

    public Interface(Deck deck) {
        this.deck = deck;
    }

    public void mostrarMenu(Map<String, String> CardsSistema) {
        int option = 0;
        long startTime, endTime, elapsedTime;

        while (option != 7) {
            System.out.println("\n1. Agregar una carta");
            System.out.println("2. Mostrar el tipo de una carta específica");
            System.out.println("3. Mostrar todas las cartas");
            System.out.println("4. Mostrar todas las cartas de la colección ordenadas por tipo");
            System.out.println("5. Mostrar todas las cartas creadas");
            System.out.println("6. Mostrar todas las cartas ordenadas por tipo");
            System.out.println("7. Salir");
            System.out.print("\nOpción: ");

            try {
                option = Functions.readDigit();
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                continue; // Solicita nuevamente la opción si ocurre una excepción
            }

            switch (option) {
                case 1:
                    startTime = System.nanoTime();
                    addCard(CardsSistema);
                    endTime = System.nanoTime();
                    elapsedTime = endTime - startTime;
                    System.out.println("Tiempo de ejecución de addCard(): " + elapsedTime + " nanosegundos");
                    break;
                case 2:
                    startTime = System.nanoTime();
                    showTypeCard(CardsSistema);
                    endTime = System.nanoTime();
                    elapsedTime = endTime - startTime;
                    System.out.println("Tiempo de ejecución de showTypeCard(): " + elapsedTime + " nanosegundos");
                    break;
                case 3:
                    startTime = System.nanoTime();
                    deck.showAllCards();
                    endTime = System.nanoTime();
                    elapsedTime = endTime - startTime;
                    System.out.println("Tiempo de ejecución de showAllCards(): " + elapsedTime + " nanosegundos");
                    break;
                case 4:
                    startTime = System.nanoTime();
                    deck.showCards();
                    endTime = System.nanoTime();
                    elapsedTime = endTime - startTime;
                    System.out.println("Tiempo de ejecución de showCards(): " + elapsedTime + " nanosegundos");
                    break;
                case 5:
                    startTime = System.nanoTime();
                    showAllCardsAvailable(CardsSistema);
                    endTime = System.nanoTime();
                    elapsedTime = endTime - startTime;
                    System.out.println("Tiempo de ejecución de showAllCardsAvailable(): " + elapsedTime + " nanosegundos");
                    break;
                case 6:
                    startTime = System.nanoTime();
                    showAllCardsAvailableInOrder(CardsSistema);
                    endTime = System.nanoTime();
                    elapsedTime = endTime - startTime;
                    System.out.println("Tiempo de ejecución de showAllCardsAvailableInOrder(): " + elapsedTime + " nanosegundos");
                    break;
                case 7:
                    System.out.println("\nPrograma terminado");
                    return;
                default:
                    System.out.println("\nError, opción no válida\n");
            }
        }
    }

    private void addCard(Map<String, String> CardsSistema) {
        System.out.print("\nNombre de la carta: ");
        String nombreCard = Functions.readEntry();
        System.out.print("Tipo de la carta (Monstruo, Trampa, Hechizo): ");
        String tipoCard = Functions.readEntry();
    
        Card card = new Card(nombreCard, tipoCard, 1);
        deck.addCard(card);
        System.out.println("\nCarta agregada");
    
        // Agregar la nueva carta al archivo
        try (PrintWriter writer = new PrintWriter(new FileWriter("cards_desc.txt", true))) {
            writer.println(nombreCard + "|" + tipoCard);
            System.out.println("Carta guardada en el archivo");
        } catch (IOException e) {
            System.err.println("Error al guardar la carta en el archivo: " + e.getMessage());
        }
    
        // Actualizar el mapa CardsSistema con la nueva carta
        CardsSistema.put(nombreCard, tipoCard);
    }
    
    

    private void showTypeCard(Map<String, String> CardsSistema) {
        System.out.print("\nIngrese el nombre de la carta: ");
        String nombreCard = Functions.readEntry();

        if (CardsSistema.containsKey(nombreCard)) {
            System.out.println("\nLa carta '" + nombreCard + "' es de tipo: " + CardsSistema.get(nombreCard));
        } else {
            System.out.println("\nLa carta '" + nombreCard + "' no se pudo encontrar");
        }
    }

    private void showAllCardsAvailable(Map<String, String> CardsSistema) {
        for (Map.Entry<String, String> entry : CardsSistema.entrySet()) {
            System.out.println("\nNombre: " + entry.getKey() + " Tipo: " + entry.getValue());
        }
    }
    
        private void showAllCardsAvailableInOrder(Map<String, String> CardsSistema) {

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
    
