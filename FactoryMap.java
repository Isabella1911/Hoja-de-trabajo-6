import java.util.HashMap;
import java.util.*;

public class FactoryMap {

    public static Map<String, Carta> crearMapa(String TypeMap) {
        switch (TypeMap) {
            case "TreeMap":
            return new TreeMap<>();
            case "HashMap":
                return new HashMap<>();
            case "LinkedHashMap":
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Error tipo de mapa no encontrado " + TypeMap);
        }
    }

}
