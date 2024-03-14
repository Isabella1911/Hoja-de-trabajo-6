import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Reader {
    public HashMap<String, String> leerArchivo(String fileName){
        HashMap<String, String> Cards = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea;
            while((linea = br.readLine())!= null){
                String[] Card = linea.split("\\|");
                Cards.put(Card[0], Card[1]);
            }
            
            System.out.println("Cartas agregadas al deck");
        } catch (IOException e) {
            System.err.println("Error al subir cartas     " + e.getMessage());
        }
        return Cards;
    }
}
