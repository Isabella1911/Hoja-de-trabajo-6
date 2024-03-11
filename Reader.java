import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Reader {

    public HashMap<String, String> leerArchivo(String fileName){
        HashMap<String, String> cartas = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea;
            while((linea = br.readLine())!= null){
                String[] carta = linea.split("\\|");
                cartas.put(carta[0], carta[1]);
            }
            
            System.out.println("Se cargarón las cartas correctamente");
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }
        return cartas;
    }
}
