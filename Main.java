/**
 * Universidad del Valle de Guatemala
* @author Isabella Obando - 23074
* @author Mia Fuentes - 23775
 * @description clase principal, que maneja todos los datos
 * @date creación 1/03/2023 última modificación 13/03/2023
 */

 import java.util.Map;

 public class Main {
     public static void main(String[] args) {
         // Seleccionar la implementación del mapa
         System.out.print("\n¿Qué tipo de mapa desea usar? (HashMap, TreeMap, LinkedHashMap):  ");
         String[] tiposMapa = {"HashMap", "TreeMap", "LinkedHashMap"};
         String tipoMapa = Functions.readEntry();
         
         if (!isValidMapType(tipoMapa, tiposMapa)) {
             System.out.println("Tipo de mapa no válido.");
             return;
         }
         
         Map<String, Card> mapa = MapFactory.crearMapa(tipoMapa);
         Reader lector = new Reader();
         Map<String, String> CardsSistema = lector.leerArchivo("cards_desc.txt");
         Deck DeckUsuario = new Deck(mapa);
 
         Interface interfaz = new Interface(DeckUsuario);
         interfaz.mostrarMenu(CardsSistema);
     }
     
     private static boolean isValidMapType(String type, String[] validTypes) {
         for (String validType : validTypes) {
             if (validType.equalsIgnoreCase(type)) {
                 return true;
             }
         }
         return false;
     }
 }
 
 