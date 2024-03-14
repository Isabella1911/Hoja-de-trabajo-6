
import java.util.HashMap;
import java.util.*;

public class MapFactory {
    public static Map<String, Card> crearMapa(String tipoMapa) {
        switch (tipoMapa) {
            case "LinkedHashMap":
            return new LinkedHashMap<>();
            case "TreeMap":
            return new TreeMap<>();
            case "HashMap":
                return new HashMap<>();
            default:
                throw new IllegalArgumentException("Mapa no reconocido " + tipoMapa);
        }
    }

}
