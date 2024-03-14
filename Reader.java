import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Reader {
    public Map<String, String> leerArchivo(String fileName) {
        Map<String, String> Cards = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] Card = linea.split("\\|");
                if (Card.length >= 2) { // Verifica si hay al menos 2 elementos después de la división
                    Cards.put(Card[0], Card[1]);
                } else {
                    System.err.println("Formato de línea incorrecto: " + linea);
                }
            }

            System.out.println("Cartas agregadas al deck");
        } catch (IOException e) {
            System.err.println("Error al subir cartas: " + e.getMessage());
        }
        return Cards;
    }
}
